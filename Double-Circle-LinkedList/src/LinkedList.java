
public class LinkedList {

	Node CreateNode() {
		Node n = new Node();

		n.setNumber(0);
		n.setLeft(null);
		n.setRight(null);

		return n;
	}

	void AddNode(Node head, int data) {

		Node L, p, n;

		n = CreateNode();
		n.setNumber(data);

		L = p = head;

		if (L.getRight() == null) {
			L.setRight(n);
			n.setLeft(L.getRight());
			n.setRight(L.getRight());
		} else {
			do {
				p = p.getRight();
			} while (p.getRight() != L.getRight());
			p.setRight(n);
			n.setLeft(p);
			n.setRight(L.getRight());
			L.getRight().setLeft(n);
		}
	}

	void NextInsertNode(Node head, int Search, int data) {

		Node L, p, n;

		n = CreateNode();
		n.setNumber(data);

		L = p = head;

		do {
			p = p.getRight();
			if (Search == p.getNumber()) {
				n.setRight(p.getRight());
				n.setLeft(p);
				p.setRight(n);
				n.getRight().setLeft(n);
				return;
			}
		} while (p.getRight() != L.getRight());
		// 검색이 되지 않았을 때 마지막에 등록
		n.setRight(p.getRight());
		n.setLeft(p);
		p.setRight(n);
		L.getRight().setLeft(n);

	}

	void PreInsertNode(Node head, int Search, int data) {

		Node L, p, n;

		n = CreateNode();
		n.setNumber(data);

		L = p = head;

		if (Search == p.getRight().getNumber()) {
			n.setRight(L.getRight());
			L.setRight(n);
			n.setLeft(n.getRight().getLeft());
			n.getRight().setLeft(n);
			n.getLeft().setRight(n);
			return;
		} else {
			do {
				p = p.getRight();
				if (Search == p.getNumber()) {
					p.getLeft().setRight(n);
					n.setLeft(p.getLeft());
					p.setLeft(n);
					n.setRight(p);
					return;
				}
			} while (p.getRight() != L.getRight());
		}
		// 검색이 되지 않았을 때 마지막에 등록
		n.setRight(p.getRight());
		n.setLeft(p);
		p.setRight(n);
		L.getRight().setLeft(n);
	}

	int SearchNode(Node head, int Search) {

		int count = 0, rlst = 0;

		Node L, p;

		L = p = head;

		do {
			++count;
			p = p.getRight();
			if (Search == p.getNumber()) {
				rlst = count;
				break;
			} else {
				rlst = -1;
			}
		} while (p.getRight() != L.getRight());

		return rlst;
	}

	void DeleteNode(Node head, int Search) {

		Node L, p;

		L = p = head;

		if (Search == L.getRight().getNumber()) {
			L.getRight().getRight().setLeft(L.getRight().getLeft());
			L.setRight(L.getRight().getRight());
			L.getRight().getLeft().setRight(L.getRight());
		} else {
			do {
				p = p.getRight();
				if (Search == p.getNumber()) {
					p.getRight().setLeft(p.getLeft());
					p.getLeft().setRight(p.getRight());
					break;
				}
			} while (p.getRight() != L.getRight());
		}
	}

	void PrintNode(Node head) {

		Node L, p;

		L = p = head;

		do {
			p = p.getRight();
			System.out.println("Number : " + p.getNumber());
		} while (p.getRight() != L.getRight());

	}

	void SortNode(Node head) {

		Node L;
		Node q, p, pq;
		Node n, m, nm;

		L = p = n = head;

		q = pq = m = nm = null;

		// L -> 4 <-> 9 <-> 8 <-> 2 <-> 7 <-> 3 <-> 5 <-> 6

		do {
			q = p;
			p = p.getRight();
			pq = p.getRight();
			do {
				m = n;
				n = n.getRight();
				nm = n.getRight();
				if (p.getNumber() < n.getNumber()) {

					if (p.getNumber() == L.getRight().getNumber()) { // p가 첫 데이터 일 때,

						// n 끊기
						m.setRight(n.getRight());
						n.getRight().setLeft(m);
						n.setLeft(null);
						n.setRight(null);

						if (pq.getNumber() == n.getNumber()) { // n이 p의 바로 옆 일 때,
							// n 연결
							n.setRight(p);
							n.setLeft(p.getLeft());
							p.getLeft().setRight(n);
							p.setLeft(n);
							L.setRight(n);
							// 제자리
							p = n;
							n = m.getRight();
						} else { // n이 p와 떨어져 있을 때,
							// p 끊기
							pq.setLeft(p.getLeft());
							p.getLeft().setRight(pq);
							L.setRight(pq);
							p.setLeft(null);
							p.setRight(null);
							// p 연결
							p.setRight(m.getRight());
							p.setLeft(m);
							m.getRight().setLeft(p);
							m.setRight(p);
							// n 연결
							n.setRight(pq);
							n.setLeft(pq.getLeft());
							pq.getLeft().setRight(n);
							pq.setLeft(n);
							L.setRight(n);
							// 제자리
							p = n;
							n = m.getRight();
						}
					} else if (n.getNumber() == L.getRight().getNumber()) { // n이 첫 데이터 일 때,

						if (nm.getNumber() == p.getNumber()) { // n이 p의 바로 옆 데이터 일 때,
							// p 끊기
							q.setRight(p.getRight());
							p.getRight().setLeft(q);
							p.setLeft(null);
							p.setRight(null);
							// p 연결
							p.setRight(n);
							p.setLeft(n.getLeft());
							n.getLeft().setRight(p);
							n.setLeft(p);
							L.setRight(p);
							// 제자리
							p = n;
							n = nm;
						} else {
							// p 끊기
							q.setRight(p.getRight());
							p.getRight().setLeft(q);
							p.setLeft(null);
							p.setRight(null);
							// n 끊기
							nm.setLeft(n.getLeft());
							n.getLeft().setRight(nm);
							L.setRight(nm);
							n.setLeft(null);
							n.setRight(null);
							// n 연결
							n.setRight(q.getRight());
							n.setLeft(q);
							q.setRight(n);
							n.getRight().setLeft(n);
							// p 연결
							p.setRight(nm);
							p.setLeft(nm.getLeft());
							nm.getLeft().setRight(p);
							nm.setLeft(p);
							L.setRight(p);
							// 제자리
							p = n;
							n = q.getRight();
						}

					} else { // 그 외 중간,
						if (p.getNumber() == nm.getNumber()) { // p와 n이 붙어 있을 때,
							// p 끊기
							q.setRight(p.getRight());
							p.getRight().setLeft(q);
							p.setLeft(null);
							p.setRight(null);
							// p 연결
							p.setRight(m.getRight());
							p.setLeft(m);
							m.setRight(p);
							q.setLeft(p);
							// 제자리
							p = n;
							n = q;
						} else {
							// p 끊기
							q.setRight(p.getRight());
							p.getRight().setLeft(q);
							p.setLeft(null);
							p.setRight(null);
							// n 끊기
							m.setRight(n.getRight());
							n.getRight().setLeft(m);
							n.setLeft(null);
							n.setRight(null);
							// n 연결
							n.setRight(q.getRight());
							n.setLeft(q);
							q.setRight(n);
							pq.setLeft(n);
							// p 연결
							p.setRight(m.getRight());
							p.setLeft(m);
							m.setRight(p);
							nm.setLeft(p);
							// 제자리
							p = n;
							n = m.getRight();
						}
					}
				}
			} while (n.getRight() != L.getRight());
		} while (p.getRight() != L.getRight());

	}

	/*
	 * void PrintNode(Node head) {
	 * 
	 * Node L, p;
	 * 
	 * L = p = head; System.out.println("첫 노드 LEFT : " +
	 * L.getRight().getLeft().getNumber()); System.out.print("L -> "); do { p =
	 * p.getRight(); //System.out.println("Number : " + p.getNumber());
	 * System.out.print(p.getNumber() + " <- -> "); } while (p.getRight() !=
	 * L.getRight()); System.out.println("\n마지막 Right : " +
	 * p.getRight().getNumber()); }
	 */

}