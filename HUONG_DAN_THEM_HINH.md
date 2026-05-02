# HƯỚNG DẪN THÊM HÌNH ẢNH VÀ SỬA MÔ TẢ CHO CÁC ITEM

## 1. CÁCH THÊM HÌNH ẢNH CHO TỪNG ITEM

### Bước 1: Chuẩn bị hình ảnh
- Chuẩn bị các file hình ảnh (định dạng: `.png`, `.jpg`, hoặc `.jpeg`)
- Đề xuất kích thước: 512x512 pixels hoặc lớn hơn để đảm bảo chất lượng
- Đặt tên file theo quy tắc: `sach.png`, `thuoc_ke.png`, `but_chi.png`, `tay.png`, `tai_nghe.png`, v.v.
  (Lưu ý: tên file **KHÔNG** được có dấu, chữ hoa, hoặc khoảng trắng)

### Bước 2: Copy hình ảnh vào thư mục drawable
1. Mở Android Studio
2. Trong project, tìm đến thư mục: `app/src/main/res/drawable/`
3. Copy tất cả file hình vào thư mục này
4. Hoặc kéo thả trực tiếp từ File Explorer vào thư mục `drawable` trong Android Studio

**VÍ DỤ CÁC FILE HÌNH:**
```
app/src/main/res/drawable/
├── sach.png
├── thuoc_ke.png
├── but_chi.png
├── tay.png
├── tai_nghe.png
├── op_lung.png
├── chuot.png
├── usb.png
└── ban_phim.png
```

### Bước 3: Cập nhật code trong MainActivity.java
Mở file: `app/src/main/java/com/example/mb_huy_bt3/MainActivity.java`

Tìm phần khởi tạo danh sách `doiDungList` và `linhKienList`, sau đó thay đổi tham số thứ 3 (icon) từ `R.drawable.ic_item` sang tên hình mới:

**VÍ DỤ:**
```java
// Danh sách Đồ dùng
doiDungList = new ArrayList<>();
doiDungList.add(new Item("Sách", "Sách học tập", R.drawable.sach));           // Đổi thành R.drawable.sach
doiDungList.add(new Item("Thước kẻ", "Thước kẻ 30cm", R.drawable.thuoc_ke)); // Đổi thành R.drawable.thuoc_ke
doiDungList.add(new Item("Bút chì", "Bút chì 2B", R.drawable.but_chi));      // Đổi thành R.drawable.but_chi
doiDungList.add(new Item("Tẩy", "Tẩy trắng", R.drawable.tay));               // Đổi thành R.drawable.tay

// Danh sách Linh kiện
linhKienList = new ArrayList<>();
linhKienList.add(new Item("Tai nghe", "Tai nghe bluetooth", R.drawable.tai_nghe));
linhKienList.add(new Item("Ốp lưng", "Ốp lưng điện thoại", R.drawable.op_lung));
linhKienList.add(new Item("Chuột", "Chuột không dây", R.drawable.chuot));
linhKienList.add(new Item("USB", "USB 32GB", R.drawable.usb));
linhKienList.add(new Item("Bàn phím không dây", "Bàn phím bluetooth", R.drawable.ban_phim));
```

**LƯU Ý:** 
- Tên file hình: `sach.png` → Code: `R.drawable.sach`
- Tên file hình: `thuoc_ke.png` → Code: `R.drawable.thuoc_ke`
- Không cần ghi đuôi file (`.png`, `.jpg`) trong code

---

## 2. CÁCH SỬA MÔ TẢ CHO CÁC ITEM

### Mở file MainActivity.java
Đường dẫn: `app/src/main/java/com/example/mb_huy_bt3/MainActivity.java`

### Tìm đến phần khởi tạo danh sách (khoảng dòng 31-43)

Cấu trúc mỗi item:
```java
new Item("Tên vật phẩm", "Mô tả vật phẩm", R.drawable.ten_hinh)
```

**VÍ DỤ CHỈNH SỬA:**

**Trước khi sửa:**
```java
doiDungList.add(new Item("Sách", "Sách học tập", R.drawable.sach));
```

**Sau khi sửa:**
```java
doiDungList.add(new Item("Sách Toán", "Sách Toán lớp 12 - NXB Giáo dục Việt Nam, 350 trang", R.drawable.sach));
```

### Ví dụ hoàn chỉnh:
```java
// ĐỒ DÙNG
doiDungList = new ArrayList<>();
doiDungList.add(new Item("Sách Toán 12", "Sách giáo khoa Toán lớp 12 - NXB Giáo dục", R.drawable.sach));
doiDungList.add(new Item("Thước kẻ Inox", "Thước kẻ inox 30cm chất lượng cao", R.drawable.thuoc_ke));
doiDungList.add(new Item("Bút chì 2B Thiên Long", "Bút chì gỗ 2B - Thương hiệu Thiên Long", R.drawable.but_chi));
doiDungList.add(new Item("Tẩy Stabilo", "Tẩy trắng Stabilo không để lại vết bẩn", R.drawable.tay));

// LINH KIỆN
linhKienList = new ArrayList<>();
linhKienList.add(new Item("Tai nghe Sony WH-1000XM5", "Tai nghe chống ồn cao cấp Sony WH-1000XM5", R.drawable.tai_nghe));
linhKienList.add(new Item("Ốp lưng iPhone 15", "Ốp lưng silicon trong suốt cho iPhone 15 Pro Max", R.drawable.op_lung));
linhKienList.add(new Item("Chuột Logitech MX Master 3", "Chuột không dây Logitech MX Master 3 cho dân văn phòng", R.drawable.chuot));
linhKienList.add(new Item("USB SanDisk 64GB", "USB 3.0 SanDisk Ultra 64GB - Tốc độ đọc 150MB/s", R.drawable.usb));
linhKienList.add(new Item("Bàn phím Keychron K2", "Bàn phím cơ Bluetooth Keychron K2 - Hot swap", R.drawable.ban_phim));
```

---

## 3. THÊM ITEM MỚI

Để thêm một vật phẩm mới:

### Bước 1: Thêm hình vào `drawable/`
```
app/src/main/res/drawable/may_tinh.png
```

### Bước 2: Thêm dòng code mới vào danh sách
```java
// Thêm vào danh sách Linh kiện
linhKienList.add(new Item("Máy tính Casio FX-580", "Máy tính khoa học Casio FX-580VN X", R.drawable.may_tinh));
```

---

## 4. BUILD VÀ CHẠY ỨNG DỤNG

Sau khi sửa xong:

1. **Clean Project**: `Build` → `Clean Project`
2. **Rebuild Project**: `Build` → `Rebuild Project`
3. **Run App**: Click nút ▶️ (Run) hoặc nhấn `Shift + F10`

---

## 5. XỬ LÝ LỖI THƯỜNG GẶP

### Lỗi: "Cannot resolve symbol 'R'"
**Giải pháp:**
- File → Sync Project with Gradle Files
- Build → Clean Project
- Build → Rebuild Project

### Lỗi: "Cannot resolve symbol 'sach'" (hoặc tên hình khác)
**Nguyên nhân:** File hình không nằm đúng thư mục hoặc tên file không hợp lệ

**Giải pháp:**
- Kiểm tra lại file hình có trong `app/src/main/res/drawable/` không
- Tên file không được có dấu, chữ hoa, khoảng trắng
- Rebuild project

### Hình bị méo hoặc không đúng tỷ lệ
**Giải pháp:**
- Sử dụng hình vuông (512x512, 1024x1024)
- Trong `activity_detail.xml`, ImageView đã được set `android:scaleType="centerCrop"` để hiển thị đẹp

---

## 6. GHI CHÚ QUAN TRỌNG

✅ **Đã bỏ icon tròn** trong ListView (màn hình chính) - chỉ hiển thị tên và mô tả
✅ **Hình vuông** trong màn hình chi tiết (250x250dp, scaleType="centerCrop")
✅ **Label đã sửa** thành "Chọn loại:" (bỏ "(Spinner)")
✅ **Bỏ dòng** "Hoặc chọn loại (Radio Button):"

---

**Chúc bạn thành công! 🎉**
