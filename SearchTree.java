package BinarySearchTree;

public class SearchTree<T extends Comparable<T>> {
	private T data;
	private SearchTree<T> left;
	private SearchTree<T> right;
	private int size;
	
	public SearchTree(T data, SearchTree<T> left, SearchTree<T> right, int size) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
		this.size = size;
	}
	
	public SearchTree(T data) {
		super();
		this.data = data;
		this.size = 1;
		this.left = null;
		this.right = null;
	}
	
	private void balance() {
		SearchTree<T> pointerToTree = null;
		int leftSize = (this.left!=null?this.left.getSize():0);
		int rightSize = (this.right!=null?this.right.getSize():0);
		if(leftSize>rightSize+2) {
			pointerToTree = this.left;
			while(pointerToTree!=null) {	
				if(pointerToTree.getRight()==null) break;
				pointerToTree = pointerToTree.getRight();
			}
		}
		if(rightSize > leftSize+2) {
			pointerToTree = this.right;
			while(pointerToTree!=null) {
				if(pointerToTree.getLeft()==null) break;
				pointerToTree = pointerToTree.getLeft();
			}
		}
		if(pointerToTree==null) return;
		T newValue = pointerToTree.getData();
		T oldValue = this.data;
		this.erase(pointerToTree);
		this.data = newValue;
		this.push(oldValue);
		if(this.left!=null) this.left.balance();
		if(this.right!=null) this.right.balance();
	}
	
	public SearchTree<T> push(T data) {
		int comparing = this.data.compareTo(data);
		SearchTree<T> pointerToNode = null;
		boolean isLeft = false;
		if(comparing > 0) {
			pointerToNode = this.left;
			isLeft = true;
		}
		else if(comparing < 0) {
			pointerToNode = this.right;
		}
		else return null;
		
		SearchTree<T> resultNode = null;
			
		if(pointerToNode==null) {
			resultNode = new SearchTree<T>(data);
			if(isLeft) this.left = resultNode;
			else this.right = resultNode;
		}
		else {
			resultNode = pointerToNode.push(data);
		}
		
		if(resultNode!=null) this.size++;
		
		this.balance();
		return resultNode;
	}

	
	public void erase(SearchTree<T> node) {
		this.erase(node.getData());
	}
	public boolean erase(T value) {
		int compareResult = this.data.compareTo(value);
		if(compareResult==0) return false;
		SearchTree<T> pointerToTree = null;
		boolean isLeft = false;
		if(compareResult>0) {
			pointerToTree = this.left;
			isLeft = true;
		}
		else pointerToTree = this.right;
		
		
		if(pointerToTree.getData().compareTo(value)==0) {
			boolean haveLeft = pointerToTree.getLeft()!=null;
			boolean haveRight = pointerToTree.getRight()!=null;
			
			if(haveLeft && haveRight) {
				SearchTree<T> findNodeToCut = pointerToTree.getLeft();
				while(findNodeToCut!=null) {
					if(findNodeToCut.getRight()==null) break; 	
					findNodeToCut = findNodeToCut.getRight();
				}
				T cutNodeValue = findNodeToCut.getData();
				pointerToTree.erase(cutNodeValue);
				pointerToTree.setData(cutNodeValue);
			}
			else if(haveLeft) {
				if(isLeft) this.left = this.left.getLeft();
				else this.right = this.right.getLeft();
			}
			else if(haveRight){
				if(isLeft) this.left = this.left.getRight();
				else this.right = this.right.getRight();
			}
			else {
				if(isLeft) this.left = null;
				else this.right = null; 
			}
			this.updateSize();
			this.balance();
			return true;
		}
		
		boolean returnValue = pointerToTree.erase(value);
		this.updateSize();
		this.balance();
		return returnValue;
	}
	
	
	public void show() {
		if(this.left!=null) this.left.show();
		System.out.print("");
		System.out.print(this.data);
		System.out.print("\n");
		if(this.right!=null) this.right.show();
	}
	
	
	private void updateSize() {
		this.size = 1;
		if(this.left!=null) this.size += this.left.getSize();
		if(this.right!=null) this.size += this.right.getSize();
	}
	
	public SearchTree<T> getLeft() {
		return left;
	}

	public void setLeft(SearchTree<T> left) {
		this.left = left;
	}

	public SearchTree<T> getRight() {
		return right;
	}

	public void setRight(SearchTree<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getSize() {
		return size;
	}
	
	
}
