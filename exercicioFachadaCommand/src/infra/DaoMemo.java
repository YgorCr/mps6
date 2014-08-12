package infra;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class DaoMemo<T> implements DaoIF<T>{
	protected abstract HashMap<Long, T> getDB();
		
	@Override
	public void delete(Long id) {
		this.getDB().remove(id);
	}
	
	@Override
	public T get(Long id) {
		return this.getDB().get(id);
	}
		
	@Override
	public void update(Long id, HashMap<String, Object> modifiedObj) {
		setCampos(modifiedObj, this.getDB().get(id));
	}
	
	@Override
	public List<T> listAll(Long max, Long offset) {
		Long from = Math.max(offset, 0L);
		Long until = from + Math.max(max, 0L);
		until = Math.min(until, this.getDB().size());
		Long size = until - from;
		
		List<T> all = new ArrayList<T>((int) Math.min(this.getDB().size(), size));
		
		for (Long i = from; i < until; ++i) {
			all.add(this.getDB().get(i));
		}
		
		return all;
	}
	
	@Override
	public List<T> listAll() {
		return listAll(new Long(this.getDB().size()), 0L);
	}
	
	@Override
	public List<T> findBy(HashMap<String, Object> attrQuery, Long max,
			Long offset) {
		List<T> rows = listAll(max, offset);
		List<T> toRemove = new ArrayList<T>();
		
		String getAttrFunctionName, attrName;
		Object objAttrValue = null, expectAttrValue;
		for (int i = 0; i < attrQuery.size(); ++i) {
			attrName = (String) attrQuery.keySet().toArray()[i];
			getAttrFunctionName = "get" +
								 attrName.substring(0,1).toUpperCase() +
								 attrName.substring(1);
			expectAttrValue = attrQuery.get(attrName);
			for (T t : rows) {
				try {
					objAttrValue = t.getClass().getMethod(getAttrFunctionName, new Class[0]).invoke(t, new Object[0]);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException
						| SecurityException e) {
					e.printStackTrace();
					continue;
				}
				if(!expectAttrValue.equals(objAttrValue)){
					toRemove.add(t);
				}
			}
		}
		
		rows.removeAll(toRemove);
		
		return rows;
	}
	
	@Override
	public List<T> findBy(HashMap<String, Object> attrQuery) {
		return findBy(attrQuery, new Long(this.getDB().size()), 0L);
	}
	
	@Override
	public T findOneBy(HashMap<String, Object> attrQuery) {
		if(!findBy(attrQuery).isEmpty()){
			return findBy(attrQuery).get(0);
		}else
			return null;
	}
	
	protected void setCampos(HashMap<String, Object> obj, Object newObj){
		String setMethodName = "";
		Field campo = null;
		Class<?>[] parametrosClasses = new Class<?>[1];
		for (String fieldName : obj.keySet()) {
			setMethodName = "set" + fieldName.substring(0,1).toUpperCase() +
							fieldName.substring(1);
			try {
				campo = newObj.getClass().getSuperclass().getDeclaredField(fieldName);
			} catch (NoSuchFieldException | SecurityException e1) {
				System.out.println("Verifique se o nome do atributo passado no HashMap esta igual ao do modelo!!!");
				e1.printStackTrace();
			}
			parametrosClasses[0] = campo.getType();
			try {
				newObj.getClass().getSuperclass().getDeclaredMethod(setMethodName, parametrosClasses).invoke(newObj, obj.get(fieldName));
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e) {
				System.out.println("Adicione método set para todos os campos do modelo!!! Método \"" + setMethodName + "(" + campo.getType().getCanonicalName() + ")\" não encontrado.");
				e.printStackTrace();
			}
		}
	}
}
