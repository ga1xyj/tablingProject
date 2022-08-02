package dev.domain;

public class Page {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int total;
	private Criteria cri;
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public Page(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;								//10.0 - 10
		this.endPage = (int) (Math.ceil(cri.getPageNum()/6.0))*6; //11~17~20
				//ceil:최댓값 함수
		this.startPage = this.endPage - 5; //9
		int realEnd = (int)(Math.ceil(total*1.0/cri.getAmount())); //175/10=>17.5->18 페이지
		
		if(this.endPage > realEnd)
			this.endPage = realEnd;
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
