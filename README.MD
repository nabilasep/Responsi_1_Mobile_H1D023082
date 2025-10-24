# Responsi 1 Mobile H1D023082

---

![Video_Hasil](images/gif.gif)

---

Aplikasi Android berbasis **Kotlin** yang menampilkan data klub sepak bola dan daftar pemainnya.  
Aplikasi ini menggunakan **RecyclerView**, **ViewModel**, dan **BottomSheetDialogFragment** untuk menampilkan detail pemain dengan tampilan modern dan interaktif.

---

## Ringkasan
- Menampilkan daftar tim dan pemain dari API eksternal.
- Setiap pemain dapat dilihat detailnya melalui tampilan **Bottom Sheet**.
- Menggunakan arsitektur sederhana berbasis **MVVM (Model - ViewModel - View)**.
- Memanfaatkan **ViewBinding** untuk interaksi yang aman antara layout XML dan kode Kotlin.

---

## Alur Aplikasi
1. **MainActivity** dijalankan pertama kali dan menampilkan daftar tim sepak bola.
2. Data diambil dari API melalui **Repository** (`TeamRepository`) dan **RetrofitInstance`.
3. Ketika pengguna memilih sebuah tim, aplikasi menampilkan daftar pemain dari tim tersebut menggunakan `SquadAdapter`.
4. Setiap item pemain memiliki event klik:
    - Saat pemain diklik, data pemain dikirim ke `PlayerFragment` menggunakan `Bundle`.
    - `PlayerFragment` ditampilkan sebagai **BottomSheetDialogFragment**, menampilkan detail seperti:
        - Nama pemain
        - Tanggal lahir
        - Kebangsaan
        - Posisi bermain
5. Pengguna dapat menutup detail dan kembali ke daftar tanpa keluar dari halaman utama.

---

## Struktur Folder
app/
└── src/
└── main/
├── java/com/unsoed/responsi1mobileh1d023082/
│ ├── data/ # Model data (tim, pemain)
│ ├── ui/
│ │ ├── adapter/ # Adapter RecyclerView
│ │ ├── fragment/ # PlayerFragment (Bottom Sheet)
│ │ └── viewmodel/ # TeamViewModel
│ └── network/ # Api dan RetrofitInstance
└── res/
├── layout/ # Layout XML (activity_main, fragment_player, item_player, dll)
└── drawable/ # Asset visual

---

## ⚙️ Cara Menjalankan
1. Clone repositori:
   ```bash
   git clone https://github.com/nabilasep/Responsi_1_Mobile_H1D023082.git
2. Buka project di Android Studio.

3. Pastikan sudah mengaktifkan ViewBinding di file build.gradle:
   android {
   ...
   buildFeatures {
   viewBinding true
   }
   }
4. Jalankan aplikasi di emulator atau perangkat fisik (minimal Android API 26+).
