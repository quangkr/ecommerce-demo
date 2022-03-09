package com.dxc.qdang.ecommercedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.qdang.ecommercedemo.model.Product;
import com.dxc.qdang.ecommercedemo.model.ProductBrand;
import com.dxc.qdang.ecommercedemo.model.ProductCategory;
import com.dxc.qdang.ecommercedemo.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    private void postConstruct() {
        ProductBrand brandApple = new ProductBrand("apple");
        ProductBrand brandSamsung = new ProductBrand("samsung");
        ProductBrand brandXiaomi = new ProductBrand("xiaomi");
        ProductBrand brandDell = new ProductBrand("dell");
        ProductBrand brandLenovo = new ProductBrand("lenovo");
        ProductCategory categoryCellphone = new ProductCategory("cellphone");
        ProductCategory categoryLaptop = new ProductCategory("laptop");

        List<Product> products = new ArrayList<>();
        products.add(new Product(
                "iPhone 11 Pro Max 512GB",
                new String[] {
                        "Màn hình: 6.5\", Super Retina XDR",
                        "HĐH: iOS 13",
                        "CPU: Apple A13 Bionic 6 nhân",
                        "RAM: 4 GB, ROM: 512 GB",
                        "Camera: 3 camera 12 MP, Selfie: 12 MP" },
                "https://cdn.tgdd.vn/Products/Images/42/210654/iphone-11-pro-max-512gb-gold-600x600.jpg",
                43990000,
                brandApple,
                categoryCellphone));

        products.add(new Product(
                "iPhone 11 Pro Max 256GB",
                new String[] {
                        "Màn hình: 6.5\", Super Retina XDR",
                        "HĐH: iOS 13",
                        "CPU: Apple A13 Bionic 6 nhân",
                        "RAM: 4 GB, ROM: 512 GB",
                        "Camera: 3 camera 12 MP, Selfie: 12 MP" },
                "https://cdn.tgdd.vn/Products/Images/42/210653/iphone-11-pro-max-256gb-black-600x600.jpg",
                37990000,
                brandApple,
                categoryCellphone));

        products.add(new Product(
                "iPhone Xs Max 256GB",
                new String[] {
                        "Màn hình: 6.5\", Super Retina",
                        "HĐH: iOS 12",
                        "CPU: Apple A12 Bionic 6 nhân",
                        "RAM: 4 GB, ROM: 256 GB",
                        "Camera: Chính 12 MP & Phụ 12 MP, Selfie: 7 MP" },
                "https://cdn.tgdd.vn/Products/Images/42/190322/iphone-xs-max-256gb-white-600x600.jpg",
                32990000,
                brandApple,
                categoryCellphone));

        products.add(new Product(
                "iPhone X 256GB",
                new String[] {
                        "Màn hình: 5.8\", Super Retina",
                        "HĐH: iOS 12",
                        "CPU: Apple A11 Bionic 6 nhân",
                        "RAM: 3 GB, ROM: 256 GB",
                        "Camera: Chính 12 MP & Phụ 12 MP, Selfie: 7 MP" },
                "https://cdn.tgdd.vn/Products/Images/42/190324/iphone-xs-256gb-white-600x600.jpg",
                27990000,
                brandApple,
                categoryCellphone));

        products.add(new Product(
                "iPhone Xs 64GB",
                new String[] {
                        "Màn hình: 5.8\", Super Retina",
                        "HĐH: iOS 12",
                        "CPU: Apple A12 Bionic 6 nhân",
                        "RAM: 4 GB, ROM: 64 GB",
                        "Camera: Chính 12 MP & Phụ 12 MP, Selfie: 7 MP" },
                "https://cdn.tgdd.vn/Products/Images/42/190321/iphone-xs-max-gold-600x600.jpg",
                24990000,
                brandApple,
                categoryCellphone));

        products.add(new Product(
                "iPhone Xr 128GB",
                new String[] {
                        "Màn hình: 6.1\", Liquid Retina",
                        "HĐH: iOS 12",
                        "CPU: Apple A12 Bionic 6 nhân",
                        "RAM: 3 GB, ROM: 128 GB",
                        "Camera: 12 MP, Selfie: 7 MP" },
                "https://cdn.tgdd.vn/Products/Images/42/191483/iphone-xr-128gb-red-600x600.jpg",
                17990000,
                brandApple,
                categoryCellphone));

        products.add(new Product(
                "iPhone 8 Plus 64GB",
                new String[] {
                        "Màn hình: 5.5\", Retina HD",
                        "HĐH: iOS 12",
                        "CPU: Apple A11 Bionic 6 nhân",
                        "RAM: 3 GB, ROM: 64 GB",
                        "Camera: Chính 12 MP & Phụ 12 MP, Selfie: 7 MP" },
                "https://cdn.tgdd.vn/Products/Images/42/114110/iphone-8-plus-hh-600x600.jpg",
                16590000,
                brandApple,
                categoryCellphone));

        products.add(new Product(
                "iPhone 7 Plus 32GB",
                new String[] {
                        "Màn hình: 5.5\", Retina HD",
                        "HĐH: iOS 12",
                        "CPU: Apple A10 Fusion 4 nhân 64-bit",
                        "RAM: 3 GB, ROM: 32 GB",
                        "Camera: Chính 12 MP & Phụ 12 MP, Selfie: 7 MP" },
                "https://cdn.tgdd.vn/Products/Images/42/78124/iphone-7-plus-32gb-gold-600x600.jpg",
                12490000,
                brandApple,
                categoryCellphone));

        products.add(new Product(
                "iPhone 7 32GB",
                new String[] {
                        "Màn hình: 4.7\", Retina HD",
                        "HĐH: iOS 12",
                        "CPU: Apple A10 Fusion 4 nhân 64-bit",
                        "RAM: 2 GB, ROM: 32 GB",
                        "Camera: 12 MP, Selfie: 7 MP" },
                "https://cdn.tgdd.vn/Products/Images/42/74110/iphone-7-gold-600x600.jpg",
                10490000,
                brandApple,
                categoryCellphone));

        products.add(new Product(
                "iPhone 13 Pro Max",
                new String[] {
                        "Màn hình 6.7\", Chip Apple A15 Bionic",
                        "RAM 6 GB, ROM 128 GB",
                        "Camera sau: 3 camera 12 MP",
                        "Camera trước: 12 MP",
                        "Pin 4352 mAh, Sạc 20 W" },
                "https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-sierra-blue-600x600.jpg",
                32490000,
                brandApple,
                categoryCellphone));

        products.add(new Product(
                "Samsung Galaxy Z Fold3 5G",
                new String[] {
                        "Màn hình Chính 7.6\" & Phụ 6.2\", Chip Snapdragon 888",
                        "RAM 12 GB, ROM 256 GB",
                        "Camera sau: 3 camera 12 MP",
                        "Camera trước: 10 MP & 4 MP",
                        "Pin 4400 mAh, Sạc 25 W" },
                "https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-600x600.jpg",
                41990000,
                brandSamsung,
                categoryCellphone));

        products.add(new Product(
                "Samsung Galaxy S21 Ultra 5G 128GB",
                new String[] {
                        "Màn hình 6.8\", Chip Exynos 2100",
                        "RAM 12 GB, ROM 128 GB",
                        "Camera sau: Chính 108 MP & Phụ 12 MP, 10 MP, 10 MP",
                        "Camera trước: 40 MP",
                        "Pin 5000 mAh, Sạc 25 W" },
                "https://cdn.tgdd.vn/Products/Images/42/226316/samsung-galaxy-s21-ultra-bac-600x600.jpg",
                25990000,
                brandSamsung,
                categoryCellphone));

        products.add(new Product(
                "Samsung Galaxy Z Flip3 5G",
                new String[] {
                        "Màn hình Chính 6.7\" & Phụ 1.9\", Chip Snapdragon 888",
                        "RAM 8 GB, ROM 128 GB",
                        "Camera sau: 2 camera 12 MP",
                        "Camera trước: 10 MP",
                        "Pin 3300 mAh, Sạc 15 W" },
                "https://cdn.tgdd.vn/Products/Images/42/229949/samsung-galaxy-z-flip-3-cream-600x600.jpg",
                24990000,
                brandSamsung,
                categoryCellphone));

        products.add(new Product(
                "Samsung Galaxy S21 5G",
                new String[] {
                        "Màn hình 6.2\", Chip Exynos 2100",
                        "RAM 8 GB, ROM 128 GB",
                        "Camera sau: Chính 12 MP & Phụ 64 MP, 12 MP",
                        "Camera trước: 10 MP",
                        "Pin 4000 mAh, Sạc 25 W" },
                "https://cdn.tgdd.vn/Products/Images/42/220833/samsung-galaxy-s21-xam-600x600.jpg",
                20990000,
                brandSamsung,
                categoryCellphone));

        products.add(new Product(
                "Samsung Galaxy S21 FE 5G",
                new String[] {
                        "Màn hình 6.4\", Chip Exynos 2100",
                        "RAM 6 GB, ROM 128 GB",
                        "Camera sau: Chính 12 MP & Phụ 12 MP, 8 MP",
                        "Camera trước: 32 MP",
                        "Pin 4500 mAh, Sạc 25 W" },
                "https://cdn.tgdd.vn/Products/Images/42/267211/Samsung-Galaxy-S21-FE-tim-600x600.jpg",
                15990000,
                brandSamsung,
                categoryCellphone));

        products.add(new Product(
                "Xiaomi 11T Pro 5G",
                new String[] {
                        "Màn hình 6.67\", Chip Snapdragon 888",
                        "RAM 8 GB, ROM 256 GB",
                        "Camera sau: Chính 108 MP & Phụ 8 MP, 5 MP",
                        "Camera trước: 16 MP",
                        "Pin 5000 mAh, Sạc 120 W" },
                "https://cdn.tgdd.vn/Products/Images/42/262566/xiaomi-11t-pro-5g-8gb-thumb-600x600.jpeg",
                13990000,
                brandXiaomi,
                categoryCellphone));

        products.add(new Product(
                "Xiaomi 11T",
                new String[] {
                        "Màn hình 6.67\", Chip MediaTek Dimensity 1200",
                        "RAM 8 GB, ROM 128 GB",
                        "Camera sau: Chính 108 MP & Phụ 8 MP, 5 MP",
                        "Camera trước: 16 MP",
                        "Pin 5000 mAh, Sạc 67 W" },
                "https://cdn.tgdd.vn/Products/Images/42/248293/Xiaomi-11T-Blue-600x600.jpg",
                10990000,
                brandXiaomi,
                categoryCellphone));

        products.add(new Product(
                "Xiaomi 11 Lite 5G NE",
                new String[] {
                        "Màn hình 6.55\", Chip Snapdragon 778G 5G 8 nhân",
                        "RAM 8 GB, ROM 128 GB",
                        "Camera sau: Chính 64 MP & Phụ 8 MP, 5 MP",
                        "Camera trước: 20 MP",
                        "Pin 4250 mAh, Sạc 33 W" },
                "https://cdn.tgdd.vn/Products/Images/42/249427/xiaomi-11-lite-5g-ne-green-600x600.jpg",
                9490000,
                brandXiaomi,
                categoryCellphone));

        products.add(new Product(
                "Xiaomi Redmi Note 10S",
                new String[] {
                        "Màn hình 6.43\", Chip MediaTek Helio G95",
                        "RAM 6 GB, ROM 128 GB",
                        "Camera sau: Chính 64 MP & Phụ 8 MP, 2 MP, 2 MP",
                        "Camera trước: 13 MP",
                        "Pin 5000 mAh, Sạc 33 W" },
                "https://cdn.tgdd.vn/Products/Images/42/262534/xiaomi-redmi-note-10s-6gb-thumb-600x600.jpeg",
                5990000,
                brandXiaomi,
                categoryCellphone));

        products.add(new Product(
                "Xiaomi Redmi 10",
                new String[] {
                        "Màn hình 6.5\", Chip MediaTek Helio G88 8 nhân",
                        "RAM 4 GB, ROM 64 GB",
                        "Camera sau: Chính 50 MP & Phụ 8 MP, 2 MP, 2 MP",
                        "Camera trước: 8 MP",
                        "Pin 5000 mAh, Sạc 18 W" },
                "https://cdn.tgdd.vn/Products/Images/42/249080/redmi-10-white-600x600.jpg",
                3990000,
                brandXiaomi,
                categoryCellphone));

        products.add(new Product(
                "Dell XPS 17 9710 i7 11800H",
                new String[] {
                        "M.Hình 17\", 4K",
                        "CPU i7, 11800H, 2.30 GHz",
                        "RAM 16 GB SSD 1 TB",
                        "Card RTX 3050 4GB",
                        "Pin 6-cell Li-ion, 97Wh" },
                "https://cdn.tgdd.vn/Products/Images/44/268712/dell-xps-17-9710-i7-xps7i7001w1-1-600x600.jpg",
                81990000,
                brandDell,
                categoryLaptop));

        products.add(new Product(
                "Dell XPS 13 9310 i5 1135G7",
                new String[] {
                        "M.Hình 13.4\", Full HD+",
                        "CPU i5, 1135G7, 2.4GHz",
                        "RAM 8 GB SSD 512 GB",
                        "Card Intel Iris Xe",
                        "Pin 4-cell, 52Wh" },
                "https://cdn.tgdd.vn/Products/Images/44/269554/dell-xps-13-9310-i5-1135g7-8gb-512gb-cap-office-600x600.jpg",
                41190000,
                brandDell,
                categoryLaptop));

        products.add(new Product(
                "Dell Latitude 3520 i7 1165G7",
                new String[] {
                        "M.Hình 15.6\", Full HD",
                        "CPU i7, 1165G7, 2.8GHz",
                        "RAM 8 GB SSD 512 GB",
                        "Card Intel Iris Xe",
                        "Pin 4-cell, 54Wh" },
                "https://cdn.tgdd.vn/Products/Images/44/252808/dell-latitude-3520-i7-70261780-091221-022033-600x600.jpg",
                30490000,
                brandDell,
                categoryLaptop));

        products.add(new Product(
                "Dell Latitude 3520 i5 1135G7",
                new String[] {
                        "M.Hình 15.6\", Full HD",
                        "CPU i5, 1135G7, 2.4GHz",
                        "RAM 8 GB SSD 256 GB",
                        "Card Intel Iris Xe",
                        "Pin 3-cell, 41Wh" },
                "https://cdn.tgdd.vn/Products/Images/44/249190/dell-latitude-3520-i5-70251593-091221-020948-600x600.jpg",
                24390000,
                brandDell,
                categoryLaptop));

        products.add(new Product(
                "Dell Inspiron 15 3511 i3 1115G4",
                new String[] {
                        "M.Hình 15.6\", Full HD",
                        "CPU i3, 1115G4, 3GHz",
                        "RAM 4 GB SSD 256 GB",
                        "Card Intel UHD",
                        "Pin 3-cell, 41Wh" },
                "https://cdn.tgdd.vn/Products/Images/44/264370/dell-inspiron-15-3511-i3-1115g4-4gb-256gb-600x600.jpg",
                14790000,
                brandDell,
                categoryLaptop));

        products.add(new Product(
                "Dell Inspiron 15 3515 R5 3450U",
                new String[] {
                        "M.Hình 15.6\", Full HD",
                        "CPU Ryzen 5, 3450U, 2.1GHz",
                        "RAM 8 GB SSD 256 GB",
                        "Card Radeon",
                        "Pin 3-cell, 41Wh" },
                "https://cdn.tgdd.vn/Products/Images/44/269307/dell-inspiron-15-3515-r5-3450u-8gb-256gb-600x600.jpg",
                18890000,
                brandDell,
                categoryLaptop));

        products.add(new Product(
                "Lenovo IdeaPad 3 14ITL6 i5 1135G7",
                new String[] {
                        "M.Hình 14\", Full HD",
                        "CPU i5, 1135G7, 2.4GHz",
                        "RAM 8 GB SSD 512 GB",
                        "Card Intel Iris Xe",
                        "Pin 2-cell, 38Wh" },
                "https://cdn.tgdd.vn/Products/Images/44/269603/lenovo-ideapad-3-14itl6-i5-1135g7-8gb-512gb-600x600.jpg",
                15890000,
                brandLenovo,
                categoryLaptop));

        products.add(new Product(
                "Lenovo Ideapad 5 15ITL05 i5 1135G7",
                new String[] {
                        "M.Hình 15.6\", Full HD",
                        "CPU i5, 1135G7, 2.4GHz",
                        "RAM 8 GB SSD 512 GB",
                        "Card Intel Iris Xe",
                        "Pin 45Wh" },
                "https://cdn.tgdd.vn/Products/Images/44/270740/lenovo-ideapad-5-15itl05-i5-82fg01h7vn-600x600.jpg",
                17690000,
                brandLenovo,
                categoryLaptop));

        products.add(new Product(
                "ThinkBook 14p G2 ACH R5 5600H",
                new String[] {
                        "M.Hình 14\"",
                        "CPU Ryzen 5, 5600H, 3.3GHz",
                        "RAM 16 GB SSD 512 GB",
                        "Card Radeon",
                        "Pin 61Wh" },
                "https://cdn.tgdd.vn/Products/Images/44/270151/thinkbook-14p-g2-ach-r5-20yn001hvn-020322-104832-600x600.jpg",
                25690000,
                brandLenovo,
                categoryLaptop));

        products.add(new Product(
                "Lenovo ThinkBook 14s G2 ITL i7 1165G7",
                new String[] {
                        "M.Hình 14\", Full HD",
                        "CPU i7, 1165G7, 2.8GHz",
                        "RAM 8 GB SSD 512 GB",
                        "Card Intel Iris Xe",
                        "Pin 4-cell, 56Wh" },
                "https://cdn.tgdd.vn/Products/Images/44/265968/lenovo-thinkbook-14s-g2-itl-i7-1165g7-8gb-600x600.jpg",
                26290000,
                brandLenovo,
                categoryLaptop));

        products.add(new Product(
                "Lenovo ThinkBook 14p G2 ACH R5 5600H",
                new String[] {
                        "M.Hình 14\", 2K",
                        "CPU Ryzen 5, 5600H, 3.3GHz",
                        "RAM 16 GB SSD 512 GB",
                        "Card Radeon",
                        "Pin 61Wh" },
                "https://cdn.tgdd.vn/Products/Images/44/271087/lenovo-thinkbook-14p-g2-ach-r5-5600h-16gb-512gb-win11-20yn001fvn-270122-090800-600x600.jpg",
                25690000,
                brandLenovo,
                categoryLaptop));

        productRepository.saveAll(products);
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

}
