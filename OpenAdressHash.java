package hash;

public class OpenAdressHash {

	final int FULL = 0;
	final int DELETED = 1;

	private class Entry {
		int key;
		Object value;
		int status;

		Entry() {
			this.key = 0;
			this.value = null;
			this.status = DELETED;
		}

		Entry(int KeySymbol, Object Value) {
			this.key = KeySymbol;
			this.value = Value;
			this.status = FULL;
		}

	}

	int hashNumber = 1000;

	Entry[] list = new Entry[hashNumber];

	public Object Get(int KeySymbol) {
		int n = Hash(KeySymbol);
		// if (this.list[n].status == 0 && this.list[n].key == KeySymbol) {
		// return this.list[n].value;
		// }
		// n = Rehash(n);
		// while (this.list[n].status == 0 && n != KeySymbol) {
		// if (this.list[n].key == KeySymbol) {
		// return this.list[n].value;
		// }
		// n = Rehash(n);
		// if (this.list[n] == null)
		// return null;
		// }

		for (int i = 0; i < hashNumber; i++) {
			if (this.list[n].status != 0)
				return null;
			if (this.list[n].key == KeySymbol)
				return this.list[n].value;
			n = Rehash(n);
			if (this.list[n] == null)
				return null;
		}

		return null;
	}

	public void Set(int KeySymbol, Object Value) {
		int n = Hash(KeySymbol);
		while (this.list[n] != null) {
			if (this.list[n].key == KeySymbol) {
				this.list[n] = new Entry(KeySymbol, Value);
				return;
			}
			n = Rehash(n);
		}
		this.list[n] = new Entry(KeySymbol, Value);
	}

	public int Hash(int i) {
		return i % hashNumber;
	}

	public int Rehash(int n) {
		return (n + 1) % hashNumber;
	}

	public void Remove(int KeySymbol) {
		int n = Hash(KeySymbol);
		if (this.list[n] == null)
			return;

		// if (this.list[n].key == KeySymbol) {
		// this.list[n] = new Entry();
		// return;
		// }
		// n = Rehash(n);
		// while (this.list[n].status == 0 && n != KeySymbol) {
		// if (this.list[n].key == KeySymbol) {
		// this.list[n] = new Entry();
		// return;
		// }
		// n = Rehash(n);
		// if (this.list[n] == null)
		// return;
		// }

		for (int i = 0; i < hashNumber; i++) {
			if (this.list[n].key == KeySymbol) {
				this.list[n] = new Entry();
				return;
			}
			n = Rehash(n);
			if (this.list[n] == null)
				return;
		}

	}

	public void Init() {
		hashNumber = 8;
		list = new Entry[hashNumber];
	}

	public static void main(String[] args) {
		OpenAdressHash test = new OpenAdressHash();
		test.Set(1, 2);
		test.Set(2, 3);
		test.Set(9, 4);
		System.out.println(test.Get(1));
		System.out.println(test.Get(2));
		System.out.println(test.Get(9));
		test.Set(1, 5);
		System.out.println(test.Get(1));
		test.Set(17, 6);
		test.Remove(1);
		System.out.println(test.Get(1));
		System.out.println(test.Get(9));
		// test.Rehash();
		// test.Init();
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
