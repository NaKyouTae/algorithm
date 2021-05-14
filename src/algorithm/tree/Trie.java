package algorithm.tree;

public class Trie {
	private TrieNode rootNode;
	
	public Trie() {
		this.rootNode = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode root = this.rootNode;
		
		for (int i = 0; i < word.length(); i++) {
			root = root.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
		}
		root.setIsLastChar(true);
	}
	
	public boolean contains(String word) {
		TrieNode temp = this.rootNode;
		
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = temp.getChildNodes().get(ch);
			
			if(node == null) return false;
			
			temp = node;
		}
		
		if(temp.isLastChar()) {
			if(temp.getChildNodes().isEmpty()) {
				return false;
			}
		}
		
		return true;
	}
	
	public void delete(String word) {
		delete(this.rootNode, word, 0);
	}
	
	public void delete(TrieNode node, String word, int idx) {
		char ch = word.charAt(idx);
		
		if(!node.getChildNodes().containsKey(ch)) throw new Error(word + " : 존재하지 않습니다.");
		
		TrieNode child = node.getChildNodes().get(ch);
		idx++;
		
		if(idx == word.length()) {
			if(!child.isLastChar()) throw new Error(word + " : 존재하지 않습니다.");
			
			child.setIsLastChar(false);
			
			if(child.getChildNodes().isEmpty()) node.getChildNodes().remove(ch);
		}else {
			delete(child, word, idx);
			
			if(!child.isLastChar() && child.getChildNodes().isEmpty()) node.getChildNodes().remove(ch);
		}
	}
	
	public boolean isRootEmpty() {
		return this.rootNode.getChildNodes().isEmpty();
	}
}
