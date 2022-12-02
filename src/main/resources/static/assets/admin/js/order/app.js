class LocationRegionResult{
    constructor(id,address, wardId, wardName, districtId, districtName, provinceId, provinceName) {
        this.id = id;
        this.address = address;
        this.wardId = wardId;
        this.wardName = wardName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }
}

class LocationRegionCreate{
    constructor(id,address, wardId, wardName, districtId, districtName, provinceId, provinceName) {
        this.id = id;
        this.address = address;
        this.wardId = wardId;
        this.wardName = wardName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }
}
class Employee {
    contructor(id, name) {
        this.id = id;
        this.name = name;
    }
}

class EmployeeResult {
    contructor(id, birthday, email, gender, name) {
        this.id = id;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.name = name;
    }
}
class ProductResult {
    constructor(id, title, image, unit, sku, retailPrice, wholesalePrice) {
            this.id = id;
            this.title = title;
            this.image = image;
            this.unit = unit;
            this.sku = sku;
            this.retailPrice = retailPrice;
            this.wholesalePrice = wholesalePrice;
    }
}

class OrderResult {
    constructor(id, employeeId, employeeResult, customerId, customerResult, discount, description, subTotal, total, granTotal ) {
        this.id =id;
        this.employeeId = employeeId;
        this.employeeResult = employeeResult;
        this.customerId = customerId;
        this.customerResult = customerResult;
        this.discount = discount;
        this.description = description;
        this.subTotal = subTotal;
        this.total = total;
        this.granTotal = granTotal;
    }
}

class OrderItemResult {
    constructor(id, orderId, productId, productResult, tax, total, quantity, price ) {
        this.id = id;
        this.productId = productId;
        this.productResult = productResult;
        this.tax = tax;
        this.total = total;
        this.total = total;
        this.quantity = quantity;
        this.price = price;
    }

}

class Customer {
    constructor(id, customerCode,  name, phone,  email,createAt, updateAt, employeeId, deleted, locationRegionCreate) {
        this.id = id;
        this.customerCode = customerCode;
        this.name = name;
        this.phone = phone;
        // this.customerGroup = customerGroup;
        this.email = email;
        // this.birthday = birthday;
        // this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.employeeId = employeeId;
        this.deleted = deleted;
        // this.locationRegionResult = locationRegionResult;
        this.locationRegionCreate = locationRegionCreate;
    }
}
class ItemResult {
    constructor(id, productId, employeeId, quantity, price, sku, discount, available) {
        this.id = id;
        this.productId = productId;
        this.employeeId = employeeId;
        this.quantity = quantity;
        this.price = price;
        this.sku = sku;
        this.discount = discount;
        this.available = available;
    }
}
class App {
    static SweetAlert = class {
        static showSuccessAlert(t) {
            Swal.fire({
                icon: 'success',
                title: t,
                position: 'top-end',
                showConfirmButton: false,
                timer: 1500
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                position: 'top-end',
                text: t,
                timer: 1500
            })
        }


        static showConfirmDelete() {
            Swal.fire({
                title: 'Bạn có chắc chắn muốn xóa sản phẩm không?',
                showDenyButton: true,
                showCancelButton: true,
                confirmButtonText: 'Xóa',
                denyButtonText: `Không!`,
            })
        }
    }

    static IziToast = class  {
        static showErrorAlert(m) {
            iziToast.error({
                title: 'Error',
                position: 'topRight',
                message: m,
                timer: 2000,

            });
        }
        static showSuccessAlert(m) {
            iziToast.success({
                title: 'Success',
                position: 'topRight',
                message: m,
                timer: 2000,
            });
        }
    }
}