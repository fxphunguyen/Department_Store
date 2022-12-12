class App {
    static DOMAIN_API = "http://localhost:8080";
    static BASE_URL_Product = this.DOMAIN_API + "/api/products";
    static BASE_URL_Categories = this.DOMAIN_API + "/api/categories";
    static BASE_URL_Brands = this.DOMAIN_API + "/api/brands";
    static BASE_URL_PRODUCT = this.DOMAIN_API + "/api/products";
    static URL_CREATE_PRODUCT = this.BASE_URL_Product + "/create";

    static AlertMessageVi = class {
        static SUCCESS_CREATED = "Tạo dữ liệu thành công !";
        static SUCCESS_UPDATED = "Cập nhật dữ liệu thành công !";

        static ERROR_400 = "Thao tác không thành công, vui lòng kiểm tra lại dữ liệu.";
        static ERROR_401 = "Unauthorized - Access Token của bạn hết hạn hoặc không hợp lệ.";
        static ERROR_403 = "Forbidden - Bạn không được quyền truy cập tài nguyên này.";
        static ERROR_404 = "Not Found - Tài nguyên này đã bị xóa hoặc không tồn tại";
        static ERROR_500 = "Internal Server Error - Hệ thống Server đang có vấn đề hoặc không truy cập được.";

    }

    static IziToast = class {
        static showSuccessAlert(m) {
            iziToast.success({
                title: 'OK',
                position: 'topRight',
                timeout: 2500,
                message: m
            });
        }

        static showErrorAlert(m) {
            iziToast.error({
                title: 'Error',
                position: 'topRight',
                timeout: 2500,
                message: m
            });
        }
    }

    static renderRowProduct(item) {
        let str = `
             <tr id="tr_${item.id}" >
                <td class="align-middle"></td>
                <td class="align-middle"><input type="checkbox" value=""></td>
                <td class="align-middle"><img width="50px" height="40px" src=${item.image} alt="image"></td>
                <td class="align-middle"><a href="/admin/product/${item.id}" style="text-decoration: none">${item.title}</a></td>
                <td class="align-middle">${item.category.name}</td>
                <td class="align-middle">${item.brand.name}</td>
                <td class="align-middle">${item.available}</td>
                <td class="align-middle">${item.inventory}</td>
                <td class="align-middle">${item.status}</td>
                <td class="align-middle">${item.createAt || ""}</td>
                <td class="align-middle">${item.updateAt || ""}</td>
            </tr>
        `;
        return str;
    }



}


class Image {
    constructor(cloudId, fileName, fileFolder, fileUrl, fileType) {
        this.cloudId = cloudId;
        this.fileName = fileName;
        this.fileFolder = fileFolder;
        this.fileUrl = fileUrl;
        this.fileType = fileType;
    }
}

class Product {
    constructor(id, title, status, description, unit, sku, barCode, quantity, retailPrice, importPrice, wholesalePrice, categoryId, brandId, applyTax, image) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.description = description;
        this.unit = unit;
        this.sku = sku;
        this.barCode = barCode;
        this.quantity = quantity;
        this.retailPrice = retailPrice;
        this.importPrice = importPrice;
        this.wholesalePrice = wholesalePrice;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.applyTax = applyTax;
        this.productImageParams = image;
    }
}

class ProductItemPage {
    constructor(id, image, title, brand, category, available, inventory, status, createAt, updateAt) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.brand = brand;
        this.category = category;
        this.available = available;
        this.inventory = inventory;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}

class Category {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
}

class Brand {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
}
class Tax{
    constructor(id,code,title,tax) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.tax = tax;
    }
}


