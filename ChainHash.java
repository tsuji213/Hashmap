package hash;

public class ChainHash {

	private class Entry {
		int key;
		Object value;
		Entry next;

		Entry(int KeySymbol, Object value) {
			this.key = KeySymbol;
			this.value = value;
		}

	}

	int hashNumber = 1000;

	Entry[] list = new Entry[hashNumber];

	public Object Get(int KeySymbol) {
		int n = Hash(KeySymbol);
		Entry entryList = this.list[n];
		while (entryList != null) {
			if (entryList.key == KeySymbol) {
				return entryList.value;
			}
			entryList = entryList.next;
		}
		return null;
	}

	public void Set(int KeySymbol, Object Value) {
		int n = Hash(KeySymbol);

		Entry entryList = this.list[n];
		if (entryList == null) {
			this.list[n] = new Entry(KeySymbol, Value);
			return;
		}
		while (entryList.next != null) {
			if (entryList.key == KeySymbol) {
				entryList.value = Value;
				return;
			}
			entryList = entryList.next;
		}
		Entry nextlist = new Entry(KeySymbol, Value);
		entryList.next = nextlist;
	}

	public int Hash(int i) {
		return i % hashNumber;
	}

	public void Rehash() {
		Entry[] oldList = list;
		hashNumber++;
		list = new Entry[hashNumber];
		for (int i = 0; i < oldList.length; i++) {
			Entry entryList = oldList[i];
			while (entryList != null) {
				this.Set(entryList.key, entryList.value);
				entryList = entryList.next;
			}
		}
	}

	public void Remove(int KeySymbol) {
		int n = Hash(KeySymbol);

		Entry entryList = this.list[n];
		if (entryList == null)
			return;
		if (entryList.key == KeySymbol) {
			this.list[n] = entryList.next;
			return;
		}
		while (entryList != null) {
			if (entryList.next != null && entryList.next.key == KeySymbol) {
				entryList.next = entryList.next.next;
			}
			entryList = entryList.next;
		}

	}

	public void Init() {
		hashNumber = 8;
		list = new Entry[hashNumber];
	}

	public static void main(String[] args) {
		ChainHash test = new ChainHash();
		test.Set(1, 2);
		test.Set(2, 3);
		test.Set(9, 4);
		System.out.println(test.Get(1));
		System.out.println(test.Get(2));
		System.out.println(test.Get(9));
		test.Set(1, 5);
		System.out.println(test.Get(1));
		test.Set(17, 6);
		test.Remove(2);
		System.out.println(test.Get(2));
		System.out.println(test.Get(9));
		test.Rehash();
		test.Init();
		// for (int i = 0; i < test.list.length; i++) {
		// System.out.println(test.list[i]);
		// }
		// test.Rehash();
		// System.out.println("Rehash");
		// for (int i = 0; i < test.list.length; i++) {
		// System.out.println(test.list[i]);
		// }

	}
}
