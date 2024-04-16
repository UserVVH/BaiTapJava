package hello;

public class MaySay extends ThietBiDien {
	private int doAmMax;

	public MaySay(String ten, int congSuat, int doAmMax) {
		super(ten, congSuat);
		this.doAmMax = doAmMax;
	}

	@Override
	public void hienThongTin() {
		super.hienThongTin();
	}

	public void bat() {
		System.out.println("Máy sấy đã bật");
		System.out.println("Độ ẩm tối đa: " + doAmMax + "%");
	}

	public void sayKho() {
		System.out.println("Máy sấy đang sấy khô");
	}

	public void tat() {
		System.out.println("Máy sấy đã tắt");
	}
}
