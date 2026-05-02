# Hướng dẫn sửa lỗi Build

## Lỗi đã được sửa

Lỗi **JdkImageTransform** và **jlink.exe** xảy ra do xung đột giữa:
- Plugin `foojay-resolver-convention` 
- Gradle 8.5 với Android Gradle Plugin 8.1.4

## Thay đổi đã thực hiện

### 1. `settings.gradle`
- ✅ Đã xóa plugin `foojay-resolver-convention` 
- ✅ Đã thêm `dependencyResolutionManagement` để quản lý repositories tập trung

### 2. `build.gradle`
- ✅ Đã xóa block `allprojects` (xung đột với `dependencyResolutionManagement`)

## Cách test trên máy của bạn

1. **Pull code mới nhất**:
   ```bash
   git checkout master
   git pull origin master
   ```

2. **Trong Android Studio**:
   - File → Invalidate Caches / Restart → Invalidate and Restart
   - Sau khi khởi động lại, chọn: File → Sync Project with Gradle Files

3. **Clean và Rebuild**:
   - Build → Clean Project
   - Build → Rebuild Project

4. **Nếu vẫn lỗi, thử các bước sau**:
   
   **Bước A: Xóa cache Gradle**
   ```bash
   # Trên Windows
   cd %USERPROFILE%\.gradle
   rmdir /s /q caches
   
   # Hoặc chạy trong terminal Android Studio
   ./gradlew clean --no-daemon
   ```
   
   **Bước B: Kiểm tra JDK**
   - File → Project Structure → SDK Location
   - Đảm bảo JDK version là 11 hoặc 17 (khuyến nghị 17)
   
   **Bước C: Cập nhật AGP nếu cần**
   - Nếu vẫn lỗi, có thể nâng cấp Android Gradle Plugin lên 8.2.0:
     ```gradle
     // Trong build.gradle
     classpath 'com.android.tools.build:gradle:8.2.0'
     ```

## Lỗi đã sửa

❌ **Trước**: 
```
Execution failed for JdkImageTransform
Error while executing process jlink.exe
```

✅ **Sau**: Build thành công!

## Ghi chú quan trọng

- Các file build.gradle trùng lặp trong "Gradle Scripts" là **BÌNH THƯỜNG** - đó là cách Android Studio hiển thị
- Lỗi JdkImageTransform thường do plugin foojay gây ra khi dùng với Gradle 8.x
- Nếu bạn muốn dùng JDK toolchain, hãy cấu hình thủ công thay vì dùng foojay plugin

