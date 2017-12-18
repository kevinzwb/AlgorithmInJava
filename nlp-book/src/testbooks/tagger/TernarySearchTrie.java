package testbooks.tagger;

import java.util.ArrayList;

public class TernarySearchTrie {

	public final class TSTNode {
		public WordEntry data = null;

		protected TSTNode left;
		protected TSTNode mid;
		protected TSTNode right;

		public char spliter;

		public TSTNode(char key) {
			this.spliter = key;
		}

		public void addWord(String w, String type, int frq) {
			if (data == null) {
				data = new WordEntry(w,PartOfSpeech.valueOf(type), frq);
			} else {
				data.addType(PartOfSpeech.valueOf(type), frq);
			}
		}

		public String toString() {
			return "data  是" + data + "   spliter是" + spliter;
		}
	}

	public TSTNode rootNode;
	public long n = 0;// 语料库中的词的总数

	/*public static void main(String[] args) {
		String sentence = "大学生活动中心";
		int offset = 0;
		WordEntry ret = dic.matchLong(sentence, offset);
		System.out.println(sentence + " match:" + ret);
		// System.out.println(dic.rootNode.getPath());
	}*/

	public TernarySearchTrie() {
	}

	public void addWord(String key, String pos, int frq) {
		if (rootNode == null) {
			rootNode = new TSTNode(key.charAt(0));
		}

		int charIndex = 0;
		TSTNode currentNode = rootNode;
		while (true) {
			int compa = (key.charAt(charIndex) - currentNode.spliter);
			if (compa == 0) {
				charIndex++;
				if (charIndex == key.length()) {
					currentNode.addWord(key, pos, frq);
					break;
				}
				if (currentNode.mid == null) {
					currentNode.mid = new TSTNode(key.charAt(charIndex));
				}
				currentNode = currentNode.mid;
			} else if (compa < 0) {
				if (currentNode.left == null) {
					currentNode.left = new TSTNode(key.charAt(charIndex));
				}
				currentNode = currentNode.left;
			} else {
				if (currentNode.right == null) {
					currentNode.right = new TSTNode(key.charAt(charIndex));
				}
				currentNode = currentNode.right;
			}
		}
	}

	public static class PrefixRet {
		public ArrayList<WordEntry> values;
		public int end; // 记录下次匹配的开始位置
	}

	// 如果匹配上则返回true，否则返回false
	public boolean matchAll(String sentence, int offset, PrefixRet prefix) {
		if (sentence == null || rootNode == null || "".equals(sentence)) {
			return false;
		}

		prefix.end = offset + 1;
		ArrayList<WordEntry> ret = new ArrayList<WordEntry>();
		TSTNode currentNode = rootNode;
		int charIndex = offset;
		while (true) {
			if (currentNode == null) {
				prefix.values = ret;
				if (ret.size() > 0) {
					return true;
				}
				return false;
			}
			int charComp = sentence.charAt(charIndex) - currentNode.spliter;
			if (charComp == 0) {
				charIndex++;
				if (currentNode.data != null) {
					System.out.println("data = " + currentNode.data);
					ret.add(currentNode.data);
				}
				if (charIndex == sentence.length()) {
					prefix.values = ret;
					if (ret.size() > 0) {
						return true;
					}
					return false;
				}
				currentNode = currentNode.mid;
			} else if (charComp < 0) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
	}

	// 创建一个结点
	public TSTNode creatTSTNode(String key) throws NullPointerException,
			IllegalArgumentException {
		if (key == null || "".equals(key)) {
			throw new NullPointerException("空指针异常");
		}
		int charIndex = 0;
		if (rootNode == null) {
			rootNode = new TSTNode(key.charAt(0));
		}
		TSTNode currentNode = rootNode;
		while (true) {
			int compa = (key.charAt(charIndex) - currentNode.spliter);
			if (compa == 0) {
				charIndex++;
				if (charIndex == key.length()) {
					return currentNode;
				}
				if (currentNode.mid == null) {
					currentNode.mid = new TSTNode(key.charAt(charIndex));
				}
				currentNode = currentNode.mid;
			} else if (compa < 0) {
				if (currentNode.left == null) {
					currentNode.left = new TSTNode(key.charAt(charIndex));
				}
				currentNode = currentNode.left;
			} else {
				if (currentNode.right == null) {
					currentNode.right = new TSTNode(key.charAt(charIndex));
				}
				currentNode = currentNode.right;
			}
		}
	}

	/*public void addWords(HashMap<String, HashSet<String>> testbooks.words) {
		for (Entry<String, HashSet<String>> e : testbooks.words.entrySet()) {
			TSTNode currentNode = creatTSTNode(e.getKey());
			currentNode.addWord(e.getKey(), e.getValue());
		}
	}*/

}