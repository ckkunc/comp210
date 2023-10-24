package assn04;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	// TODO: insert
	@Override
	public BST<T> insert(T element){
		if (element.compareTo(_element) < 0) {
			_left = _left.insert(element);
		} else if (element.compareTo(_element) > 0) {
			_right = _right.insert(element);
		}
		return this;
	}

	// TODO: findMin
	@Override
	public T findMin() {
		if (_left.isEmpty()	) {
			return _element;
		} else {
			return _left.findMin();
		}
	}

	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		if (element.compareTo(_element) < 0) {
			_left = _left.remove(element);
		} else if (element.compareTo(_element) > 0) {
			_right = _right.remove(element);
		} else { //element equals _element
			if (_left.isEmpty() && _right.isEmpty()) {
				// leaf
				return new EmptyBST<T>();
			} else if (_left.isEmpty()) {
				// has one child on the left
				return _right;
			} else if (_right.isEmpty()) {
				// has one child on the right
				return _left;
			} else {
				// has two children
				T successor = _right.findMin(); // find the successor
				_element = successor; // replace current node with the successor
				_right = _right.remove(successor); // delete the successor from the right subtree
			}
		}
		return this;
	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		System.out.print(_element + " ");
		if (!_left.isEmpty()){
			_left.printPreOrderTraversal();
		}
		if (!_right.isEmpty()) {
			_right.printPreOrderTraversal();
		}
	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		if (!_left.isEmpty()){
			_left.printPostOrderTraversal();
		}
		if (!_right.isEmpty()) {
			_right.printPostOrderTraversal();
		}
		System.out.print(_element + " ");
	}

	@Override
	public int getHeight() {
		   return Math.max(_left.getHeight(), _right.getHeight())+1;
	}

	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
}
