package cn.sm1234.domain;

import java.util.List;

public class EasyUIDatagrid {
	//当前页显示的数据
		private List<?> rows;
		//表中总个数
		private int total;
		public List<?> getRows() {
			return rows;
		}
		public void setRows(List<?> rows) {
			this.rows = rows;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		@Override
		public String toString() {
			return "EasyUIDatagrid [rows=" + rows + ", total=" + total + "]";
		}

}
