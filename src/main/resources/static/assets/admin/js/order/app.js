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