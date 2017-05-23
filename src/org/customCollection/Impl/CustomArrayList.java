package org.customCollection.Impl;

public class CustomArrayList<T> implements CustomList<T> {
	private Object[] items = new Object[3];
	private int size = 0;

	@Override
	public void add(T item) {
		if (size > items.length - 1) {
			resize();
			System.out.println(size);
			items[size] = item;
			size++;
		} else {
			items[size] = item;
			size++;
		}
	}

	@Override
	public void remove() {
		items[size - 1] = null;
		size--;
	}

	@Override
	public void remove(int index) {
		for (int i = index; i < size - 1; i++) {
			items[i] = items[i + 1];
		}
		items[size - 1] = null;
		size--;
	}

	@Override
	public T get(int index) {
		/* System.out.println(size); */
		// TODO Auto-generated method stub
		if (index < 0 || index >= size)
			return null;
		else
			return (T) items[index];
	}

	@Override
	public void addAll(CustomList<T> list) {
		for (int i = 0; i < list.size(); i++) {
			this.add(list.get(i));
		}
	}

	@Override
	public void add(int index, T item) {
		if (size > items.length - 1) {
			resize();
			for (int i = size; i > index; i--) {
				items[i - 1] = items[i];
			}
			items[index] = item;
			size++;
		} else {
			for (int i = size; i > index; i--) {
				items[i - 1] = items[i];
			}
			items[index] = item;
			size++;
		}
	}

	@Override
	public void clear() {
		for(int i = 0; i < size; i++){
			this.items[i] = null;
		}
		size=0;
	}

	@Override
	public boolean contains(T item) {
		for (int i = 0; i < size; i++) {
			if (items[i].equals(item)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(CustomArrayList<T> list) {
		for(int i = 0; i < list.size ; i++){
			if(!this.contains(list.get(i))){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equals(CustomList<Object> list) {
		if (list.size() != size) {
			return false;
		}
		if (list.isEmpty() && this.isEmpty()) {
			return true;
		}
		if (list.isEmpty() && !this.isEmpty() || this.isEmpty() && !list.isEmpty()) {
			return false;
		}
		for (int i = 0; i < size; i++) {
			if (list.get(i) != items[i]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		if (size > 0)
			return false;
		else
			return true;
	}

	@Override
	public int size() {
		return size;
	}

	public void resize() {
		Object[] temp = items;
		items = new Object[size * 2];
		System.arraycopy(temp, 0, items, 0, size);
	}

}
