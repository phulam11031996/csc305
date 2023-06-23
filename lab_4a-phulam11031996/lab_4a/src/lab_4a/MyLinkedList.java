package lab_4a;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyLinkedList <E> implements Multiset<E> {

	private List<E> list = new ArrayList<>();

	@Override
	public void add(E element) {
		// EODO Auto-generated method stub
		this.list.add(element);

	}

	@Override
	public boolean remove(E element) {
		// EODO Auto-generated method stub
		boolean flag = false;

		for (int i = this.list.size() - 1; i >= 0; i--) {
			if (this.list.get(i).equals(element)) {
				this.list.remove(i);
				flag = true;
			}
		}

		return flag;
	}

	@Override
	public int size() {
		// EODO Auto-generated method stub
		return this.list.size();
	}

	@Override
	public int count(E element) {
		// EODO Auto-generated method stub
		int count = 0;

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).equals(element)) {
				count++;
			}
		}
		
		return count;
	}

	@Override
	public Optional<E> grab() {
		// EODO Auto-generated method stub
		if (this.list.isEmpty())
			return Optional.empty();
		else
//			return Optional.of(this.list.get(0));
			return Optional.ofNullable(this.list.get(0));
	}

}
