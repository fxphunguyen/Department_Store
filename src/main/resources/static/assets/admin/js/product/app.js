class App {
    static DOMAIN_API = "http://localhost:8080";
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

    static renderRowProduct(product) {
        let str =`
             <tr id="tr_${product.id}" >
                <td class="align-middle"></td>
                <td class="align-middle"><input type="checkbox" value=""></td>
                <td class="align-middle"><img width="70px" height="50px" src=${product.image} alt=""></td>
                <td class="align-middle">${product.title}</td>
                <td class="align-middle">${product.categoryName}</td>
                <td class="align-middle">${product.brandName}</td>
                <td class="align-middle">${product.available}</td>
                <td class="align-middle">${product.available + product.trading}</td>
                <td class="align-middle">${product.status}</td>
                <td class="align-middle">${product.createAt}</td>
                <td class="align-middle">${product.updateAt}</td>
            </tr>
        `;
        return str;
    }
}

class Product {
    constructor(id, image, title, categoryName, brandName, available, trading, status, createAt,updateAt) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.categoryName = categoryName;
        this.brandName = brandName;
        this.available = available;
        this.trading = trading;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}