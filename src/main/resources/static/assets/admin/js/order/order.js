let customer = new Customer()
let locationRegionCreate = new LocationRegionCreate();
let employee = new Employee();

function removeEventModal() {
    $("#btnCreateCustomer").off("click");
}


let customers = [];

let employees = [];

function showListCustomer   () {
        $.ajax({
            type: "GET", contentType: 'application/json',
            url: `${location.origin}/api/customers/list_customer`
        })
            .done((data) => {
                customers = data;
                // customer.locationRegionCreate = locationRegionCreate;
                // console.log(data)
                $(".searchCustomer").removeClass('d-none');
                $(".contentCustomer div").remove();
                $.each(data, (i, customer) => {
                    let result = `
                <div class="MuiBox-root jss4978 InfiniteScroll-MenuItem focus-key-event showInfo" key-event="true" onclick="showCustomerInfo(${customer.id})"
                     data-id="${customer.id}" tabindex="0">
                    <li class="MuiButtonBase-root MuiListItem-root MuiMenuItem-root jss2894 MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button"
                        tabindex="-1" role="menuitem" aria-disabled="false">
                        <svg class="MuiSvgIcon-root icon" focusable="false" viewBox="0 0 24 24" aria-hidden="true">
                            <path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 3c1.66 0 3 1.34 3 3s-1.34 3-3 3-3-1.34-3-3 1.34-3 3-3zm0 14.2c-2.5 0-4.71-1.28-6-3.22.03-1.99 4-3.08 6-3.08 1.99 0 5.97 1.09 6 3.08-1.29 1.94-3.5 3.22-6 3.22z"></path>
                        </svg>
                        <div class="MuiBox-root jss4983"><p
                                class="MuiTypography-root MuiTypography-body1 MuiTypography-noWrap">${customer.name}</p>
                                <h6 class="MuiTypography-root MuiTypography-subtitle1 MuiTypography-noWrap">${customer.phone}</h6></div>
                        <span class="MuiTouchRipple-root"></span>
                    </li>
                </div>
                `;
                    $(".contentCustomer").append(result)
                })
                handleCloseListCustomers();
            })
            .fail((jqXHR) => {
                console.log(jqXHR);
            })
}
showListCustomer();

$("#myInput").on("input", function () {
    // console.log($(this).val());
    // console.log(customers)
    let search = $(this).val();
    let results = [];
    customers.forEach((item) => {
        if (((item.name).toLowerCase()).includes(search.toLowerCase()) || ((item.phone).toLowerCase()).includes(search.toLowerCase())) {
            results.push(item);
        }
    })

    $(".searchCustomer").removeClass('d-none');
    $(".contentCustomer div").remove();
    $.each(results, (i, customer) => {
        let result = `
                <div class="MuiBox-root jss4978 InfiniteScroll-MenuItem focus-key-event showInfo" key-event="true" onclick="showCustomerInfo(${customer.id})"
                     data-id="${customer.id}" tabindex="0">
                    <li class="MuiButtonBase-root MuiListItem-root MuiMenuItem-root jss2894 MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button"
                        tabindex="-1" role="menuitem" aria-disabled="false">
                        <svg class="MuiSvgIcon-root icon" focusable="false" viewBox="0 0 24 24" aria-hidden="true">
                            <path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 3c1.66 0 3 1.34 3 3s-1.34 3-3 3-3-1.34-3-3 1.34-3 3-3zm0 14.2c-2.5 0-4.71-1.28-6-3.22.03-1.99 4-3.08 6-3.08 1.99 0 5.97 1.09 6 3.08-1.29 1.94-3.5 3.22-6 3.22z"></path>
                        </svg>
                        <div class="MuiBox-root jss4983"><p
                                class="MuiTypography-root MuiTypography-body1 MuiTypography-noWrap">${customer.name}</p>
                                <h6 class="MuiTypography-root MuiTypography-subtitle1 MuiTypography-noWrap">${customer.phone}</h6></div>
                        <span class="MuiTouchRipple-root"></span>
                    </li>
                </div>
                `;
        $(".contentCustomer").append(result);

    })

    handleCloseListCustomers();
})


function showCustomerInfo(idCustomer) {
    // console.log(idCustomer);
    // handleCloseListCustomers();

    $("#MuiBox-list-customer").addClass("hide");

    $("#idCustomer").val(idCustomer);
    let result = {};

    customers.forEach((item) => {
        result = item;
        if (item.id == idCustomer) {
            return false;
        }
    })
    console.log(result);
    let str = `<div class="MuiPaper-root  jss938 MuiPaper-elevation1 MuiPaper-rounded" id="closed_customer_info">
        <div class="MuiBox-root jss985">
            <div class="MuiBox-root jss3887 jss939">
                <div class="MuiBox-root jss3888">
                    <h6 class="MuiTypography-root MuiTypography-h6" style="display: flex; align-items: center;"><svg
                            class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true"
                            style="color: rgb(163, 168, 175); font-size: 22px; margin-right: 10px;">
                            <path
                                d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 3c1.66 0 3 1.34 3 3s-1.34 3-3 3-3-1.34-3-3 1.34-3 3-3zm0 14.2c-2.5 0-4.71-1.28-6-3.22.03-1.99 4-3.08 6-3.08 1.99 0 5.97 1.09 6 3.08-1.29 1.94-3.5 3.22-6 3.22z">
                            </path>
                        </svg>Thông tin khách hàng</h6>
                    <div class="MuiBox-root jss3889"><a target="_blank" href="/admin/customers/181966855"
                            style="text-decoration: none; display: inline-flex; align-items: center;">
                            <h6 class="MuiTypography-root MuiTypography-h6 MuiTypography-colorPrimary"
                                title="Denise Zimmerman">${result.name}</h6>
                            <h6 class="MuiTypography-root MuiTypography-h6 MuiTypography-colorTextPrimary">
                                &nbsp;-&nbsp;${result.phone}</h6>
                        </a>
                        <button
                            class="MuiButtonBase-root MuiIconButton-root jss948 MuiIconButton-colorSecondary MuiIconButton-sizeSmall"
                            tabindex="0" 
                            onclick="handleRemove()"
                            type="button">
                            <span class="MuiIconButton-label">
                            <svg viewBox="0 0 24 24"
                                    fill="none" xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                    font-size="20">
                                    <path
                                        d="M19 6.41 17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12 19 6.41Z"
                                        fill="currentColor"></path>
                                </svg>
                                </span>
                                <span class="MuiTouchRipple-root"></span>
                                </button>
                                </div>
                </div>
            </div>
            <div class="MuiBox-root jss3895 jss942">
                <div class="MuiBox-root jss3896 jss952">
                    <div class="MuiBox-root jss3897">
                        <div class="MuiBox-root jss3898 jss944">
                            <div class="MuiBox-root jss3899">
                                <p class="MuiTypography-root jss941 MuiTypography-body2">Địa chỉ giao hàng</p>
                            </div>
                            <div class="MuiBox-root jss3900">
                                <p class="MuiTypography-root MuiTypography-body2">${result.phone}</p>
                                <p class="MuiTypography-root MuiTypography-body2">${result.locationRegionResult.address}</p>
                            </div>
                        </div>
                        <div class="MuiBox-root jss3901 jss945 jss947">
                            <div class="MuiBox-root jss3911 jss3902">
                                <li class="MuiListItem-root MuiListItem-gutters" style="padding: 5px 8px;">
                                    <div class="MuiListItemText-root">
                                        <p class="MuiTypography-root jss3903 MuiTypography-body1">Nợ phải thu</p>
                                    </div>
                                    <div class="MuiListItemText-root">
                                        <p
                                            class="MuiTypography-root jss3910 MuiTypography-body1 MuiTypography-colorError MuiTypography-alignRight">
                                            -2,474,816</p>
                                    </div>
                                </li>
                                <li class="MuiListItem-root MuiListItem-gutters"
                                    style="cursor: pointer; padding: 5px 8px;">
                                    <div class="MuiListItemText-root">
                                        <p class="MuiTypography-root jss3903 MuiTypography-body1">Tổng chi tiêu (0 đơn)
                                        </p>
                                    </div>
                                    <div class="MuiListItemText-root">
                                        <p
                                            class="MuiTypography-root jss3910 MuiTypography-body1 MuiTypography-colorPrimary MuiTypography-alignRight">
                                            834</p>
                                    </div>
                                </li>
                                <div class="MuiBox-root jss3912">
                                    <li class="MuiListItem-root MuiListItem-gutters"
                                        style="cursor: pointer; padding: 5px 8px;">
                                        <div class="MuiListItemText-root">
                                            <p class="MuiTypography-root jss3903 MuiTypography-body1">Trả hàng (0 sản
                                                phẩm)</p>
                                        </div>
                                        <div class="MuiListItemText-root">
                                            <p
                                                class="MuiTypography-root jss3910 MuiTypography-body1 MuiTypography-colorError MuiTypography-alignRight">
                                                0</p>
                                        </div>
                                    </li>
                                    <li class="MuiListItem-root MuiListItem-gutters"
                                        style="cursor: pointer; padding: 5px 8px;">
                                        <div class="MuiListItemText-root">
                                            <p class="MuiTypography-root jss3903 MuiTypography-body1">Giao hàng thất bại
                                                (0 đơn)</p>
                                        </div>
                                        <div class="MuiListItemText-root">
                                            <p
                                                class="MuiTypography-root jss3910 MuiTypography-body1 MuiTypography-colorError MuiTypography-alignRight">
                                                0</p>
                                        </div>
                                    </li>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="MuiBox-root jss4275">
                        <div class="MuiBox-root jss4276 jss944">
                            <div class="MuiBox-root jss4277">
                                <p class="MuiTypography-root jss941 MuiTypography-body2">Địa chỉ nhận hóa đơn</p>
                                <button
                                    class="MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary"
                                    tabindex="0"
                                    onclick="editCustomer()"
                                     type="button"
                                    style="margin: 0px 4px; height: 15px; min-width: unset;"><span
                                        class="MuiButton-label">Thay đổi</span><span
                                        class="MuiTouchRipple-root"></span>
                                </button>
                            </div>
                            <div class="MuiBox-root jss4278">
                                <p class="MuiTypography-root MuiTypography-body2">${result.phone}</p>
                                <p class="MuiTypography-root MuiTypography-body2">${result.locationRegionResult.address}</p>
                            </div>
                        </div>
                        <div class="MuiBox-root jss4279 jss945">
                            <div class="MuiBox-root jss4280">
                                <p class="MuiTypography-root jss941 MuiTypography-body2">Liên hệ</p>
                            </div>
                            <p class="MuiTypography-root MuiTypography-body2" style="color: rgb(163, 168, 175);">Chưa có
                                thông tin liên hệ</p>
                            <div class="MuiFormControl-root jss1315 MuiFormControl-fullWidth"
                                style="padding-top: 16px;">
                                <div class="MuiFormControl-root MuiTextField-root jss1317 MuiFormControl-fullWidth">
                                    <div
                                        class="MuiInputBase-root MuiOutlinedInput-root MuiInputBase-fullWidth MuiInputBase-formControl">
                                        <input aria-invalid="false" id="557fa869-3d86-41db-933d-de2fc27a08c6"
                                            placeholder="Email" type="text" aria-label="Without label" maxlength="200"
                                            class="MuiInputBase-input MuiOutlinedInput-input"
                                            value=${result.email} >
                                        <fieldset aria-hidden="true" class="jss1037 MuiOutlinedInput-notchedOutline"
                                            style="padding-left: 8px;">
                                            <legend class="jss1038" style="width: 0.01px;"><span>​</span></legend>
                                        </fieldset>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>`;

    $("#show_customer_info").html(str);

}



function handleCloseListCustomers() {
    $(document).on("click", () => {
        $(".searchCustomer").addClass('d-none');

    })
}

function showListProducts() {
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        url: `${location.origin}/api/products/show_list`
    })
        .done((data) => {
            $(".searchProduct").removeClass('d-none');
            $(".contentProduct div").remove();
            $.each(data, (i, product) => {
                let result = `             
                    <div class="MuiBox-root jss3941 InfiniteScroll-MenuItem focus-key-event" key-event="true"
                    onclick="showProductInfo(${product.id})" data-id="${product.id}" tabindex="0">
                    <li class="MuiButtonBase-root MuiListItem-root MuiMenuItem-root jss1259 MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button" tabindex="-1" role="menuitem" aria-disabled="false">
                        <img class="jss1260" src="${product.image}">
                            <div class="MuiBox-root jss3946">
                                <div class="MuiBox-root jss3947">
                                    <p class="MuiTypography-root MuiTypography-body1" style="white-space: break-spaces;">${product.title}</p>
                                        <p class="MuiTypography-root MuiTypography-body2" style="line-height: 16px; display: flex;">
                                        <span class="MuiTypography-root MuiTypography-body2" style="color: rgb(163, 168, 175); line-height: 16px;">${product.sku}</span>
                                        <span class="MuiTypography-root jss1258 MuiTypography-body2 MuiTypography-colorPrimary" title="Mặc định">Mặc định</span>
                                    </p>
                                </div>
                                <div class="MuiBox-root jss3953">
                                    <h6 class="MuiTypography-root MuiTypography-h6">${product.retailPrice}</h6>
                                        <p class="MuiTypography-root MuiTypography-body1" style="margin-top: 4px;">
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(163, 168, 175);">Tồn:  </span>
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(0, 136, 255);">${product.quantity}</span>
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(163, 168, 175);">&nbsp;| Có thể bán: </span>
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(0, 136, 255);">${product.quantity}</span>
                                        </p>
                                </div>
                            </div>
                        <span class="MuiTouchRipple-root"></span>
                    </li>
                </div>                       
                `;
                $(".contentProduct").append(result)
            })

            handleCloseListProducts();
        })
        .fail((jqXHR) => {
            console.log(jqXHR);
        })
}

function handleCloseListProducts() {
    $(document).on("click", () => {
        // $(".contentCustomer div").empty();
        $(".searchProduct").addClass('d-none');
    })
}

function getAllProvinces() {
    return $.ajax({
        headers: {
            "accept": "application/json",
            "content-type": "application/json"
        },
        type: "GET",
        url: "https://vapi.vnappmob.com/api/province/"
    })
        .done((data) => {
            $.each(data.results, (i, item) => {
                let str = `<option value="${item.province_id}">${item.province_name}</option>`;
                $("#province").append(str);
                $('#provinceUpdate').append(str);
            });
        })
        .fail((jqXHR) => {

        })
}

    function getAllDistrictsByProvinceId(provinceId) {
    $("#district").empty();
    return $.ajax({
        headers: {
            "accept": "application/json",
            "content-type": "application/json"
        },
        type: "GET",
        url: "https://vapi.vnappmob.com/api/province/district/" + provinceId
    })
        .done((data) => {
            if (data.results.length === 0) {
                let str = `<option value="0">Chọn Quận/Huyện</option>`;
                $("#district").append(str);
                $('#districtUpdate').append(str);

            } else {
                $.each(data.results, (i, item) => {
                    let str = ` <option value="${item.district_id}">${item.district_name}</option>`;
                    $("#district").append(str);
                    $('#districtUpdate').append(str);
                })

            }
        })
        .fail((jqXHR) => {
        })
}

function getAllWardsByDistrictId(districtId) {
    $("#ward").empty();
    return $.ajax({
        headers: {
            "accept": "application/json",
            "content-type": "application/json"
        },
        type: "GET",
        url: "https://vapi.vnappmob.com/api/province/ward/" + districtId
    })
        .done((data) => {
            // $('#ward').html('');
            // $('#wardUpdate').html('');

            if (data.results.length === 0) {
                let str = `<option value="0">Chọn Phường/Xã</option>`;
                $("#ward").append(str);
                $('#wardUpdate').append(str);

            } else {
                $.each(data.results, (i, item) => {
                    let str = `<option value="${item.ward_id}">${item.ward_name}</option>
                                `;
                    $("#ward").append(str);
                    $('#wardUpdate').append(str);
                });
            }
        })
        .fail((jqXHR) => {
        })
}

getAllProvinces().then(() => {
    let provinceId = $("#province").val();

    getAllDistrictsByProvinceId(provinceId).then(() => {

        let districtId = $("#district").val();

        getAllWardsByDistrictId(districtId);
    });
});
$("#province").on('change', () => {
    let provinceId = $("#province").val();
    getAllDistrictsByProvinceId(provinceId).done(() => {
        let districtId = $("#district").val();
        getAllWardsByDistrictId(districtId);
    })

    $("#district").on('change', () => {
        let districtId = $("#district").val();
        getAllWardsByDistrictId(districtId);
    })
});

function getEmployeeById(id) {
    return $.ajax({
        headers: {
            "accept": "application/json",
            "content-type": "application/json"
        },
        type: "GET",
        url: `${location.origin}/api/employees/` + id
    })
        .done((data) => {
            // $('#selectEmployee').html('');
            // $('#selectEmployeeUpdate').html('');
            employees = data;
            if (data.length === 0) {
                let str = `<option value="0">Chọn nhân viên</option>`;
                $("#selectEmployee").append(str);
            } else {
                $.each(data, (i, item) => {
                    let str = `<option value="${item.id}">${item.name}</option>`;
                    $("#selectEmployee").append(str);
                });
            }

        })
        .fail((jqXHR) => {
            console.log(jqXHR)
        })
}
getAllEmployeeSelect();

$('#btnCreateCustomer').on('click', () => {
    customer.id = null;
    customer.name = $('#nameCreate').val();
    customer.customerCode = $('#codeCreate').val();
    // customer.customerGroup = $('#customerGroupCreate :selected').val();
    customer.phone = $('#phoneCreate').val();
    customer.email = $('#emailCreate').val();
    // customer.birthday = $('#birthdayCreate').val();
    // customer.status = $('#statusCreate').val
    // customer.gender = $('#genderCreate :selected').val();
    // customer.createAt = $('#birthdayCreate').val();
    // customer.updateAt = null;
    customer.locationRegionCreate = locationRegionCreate;

    console.log(locationRegionCreate);


    locationRegionCreate.address = $('#addressCreate').val();
    locationRegionCreate.provinceId = $('#province').val();
    locationRegionCreate.provinceName = $('#province :selected').text();
    locationRegionCreate.districtId = $('#district').val();
    locationRegionCreate.districtName = $('#district :selected').text();
    locationRegionCreate.wardId = $('#ward').val();
    locationRegionCreate.wardName = $('#ward :selected').text();
    customer.employeeId = $('#selectEmployee').val();

    $.ajax({
        "headers": {
            "accept": "application/json",
            "content-type": "application/json"
        },
        "type": "POST",
        "url": "http://localhost:8080/api/customers/create",
        "data": JSON.stringify(customer)
    })
        .done((data) => {
            customer = data;

            customer.locationRegionCreate = locationRegionCreate;
            removeEventModal();
            $("#create_order_customer").modal("hide");
            App.IziToast.showSuccessAlert("Thêm khách hàng thành công!");
            $('#nameCreate').val("");
            $('#codeCreate').val("");
            $('#phoneCreate').val("");
            $('#emailCreate').val("");
            $('#addressCreate').val("");
            $('#province').val("0").change();
            $('#district').val("0").change();
            $('#ward').val("0").change();
            $('#selectEmployee').val("0").change();
        })
        .fail((jqXHR) => {
            console.log(jqXHR)
        })
});

function handleRemove(){
    let str = `<div class="MuiPaper-root  jss18028 MuiPaper-elevation1 MuiPaper-rounded">
                                        <div class="MuiBox-root jss18075 customer-info">
                                            <div class="MuiBox-root jss18076 create-order-step2 jss18040">
                                                <div class="MuiBox-root jss18077">
                                                    <h6 class="MuiTypography-root MuiTypography-h6">Thông tin khách
                                                        hàng</h6>
                                                </div>
                                                <div class="jss18078 SI-root">
                                                    <form autocomplete="off" class="MuiPaper-root jss18080 SearchBox MuiPaper-elevation1 MuiPaper-rounded">
                                                        <div class="MuiFormControl-root MuiTextField-root jss18081 MuiFormControl-fullWidth autocomplete">
                                                            <div class="MuiInputBase-root MuiOutlinedInput-root MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedStart MuiOutlinedInput-adornedStart">
                                                                <div class="MuiInputAdornment-root MuiInputAdornment-positionStart">
                                                                    <svg class="MuiSvgIcon-root" focusable="false"
                                                                         viewBox="0 0 24 24" color="#A3A8AF"
                                                                         aria-hidden="true"
                                                                         style="width: 24px; height: 24px;">
                                                                        <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                                                                    </svg>
                                                                </div>
                                                                <input aria-invalid="false"
                                                                       id="myInput"
                                                                       name="myInput"
                                                                       placeholder="Tìm theo tên, SĐT, mã khách hàng ... (F4)"
                                                                       type="text"
                                                                       onclick="showListCustomer()"
                                                                       class="MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart MuiOutlinedInput-inputAdornedStart"
                                                                       value="">
                                                                <fieldset aria-hidden="true"
                                                                          class="jss18127 MuiOutlinedInput-notchedOutline"
                                                                          style="padding-left: 8px;">
                                                                    <legend class="jss18128" style="width: 0.01px;">
                                                                        <span>​</span></legend>
                                                                </fieldset>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="MuiBox-root jss18132 jss18039">
                                                    <p class="MuiTypography-root MuiTypography-body1"
                                                       style="color: rgb(163, 168, 175); margin-top: 16px;">
                                                        Chưa có thông tin khách hàng</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>`;
    $("#show_customer_info").html(str);
    $("#MuiBox-list-customer").removeClass("hide");
}
function getCustomerById(id) {
    return $.ajax({
        headers: {
            accept: "application/json",
            "content-type": "application/json"
        },
        type: "GET",
        url: "http://localhost:8080/api/customers/" + id
    })
        .done((data) => {
            customer = data;
            customer.locationRegionCreate = locationRegionCreate;
            console.log(customer);
            console.log(locationRegionCreate);
        })
        .fail((jqXHR) => {
            console.log(jqXHR);
        })
}



function editCustomer() {
    let id =  $("#idCustomer").val();
    console.log(id);
        getCustomerById(id).then( ()  => {


            $('#idCustomer').val(customer.id);
            $("#nameUpdate").val(customer.name)
            $('#phoneUpdate').val(customer.phone);
            $('#addressUpdate').val(locationRegionCreate.address);
            $('#provinceUpdate').val(locationRegionCreate.provinceId);

            getAllDistrictsByProvinceId(locationRegionCreate.provinceId).then(()=>{
                $("#districtUpdate").val(locationRegionCreate.districtId);

                console.log(locationRegionCreate.districtId);

                getAllWardsByDistrictId(locationRegionCreate.districtId).then(()=>{
                    $("#wardUpdate").val(locationRegionCreate.wardId);
                })
            })
            getAllEmployeeSelect().then(() => {
                $("#selectEmployeeUpdate").val(employee.id);
            })

            $("#update_order_customer").modal("show");

            // $("#modalCreateProduct .modal-alert-danger").removeClass('show').addClass('hide');
        })
}

// $('#btnUpdateCustomer').on('click', (customerId) => {
//
//     $.ajax({
//         "headers": {
//             "accept": "application/json",
//             "content-type": "application/json"
//         },
//         "type": "POST",
//         "url": "http://localhost:8080/api/customers/create",
//         "data": JSON.stringify(customer)
//     })
//         .done((data) => {
//             removeEventModal();
//             $("#create_order_customer").modal("hide");
//             App.IziToast.showSuccessAlert("Thêm khách hàng thành công!");
//             $('#nameCreate').val("");
//             $('#codeCreate').val("");
//             $('#phoneCreate').val("");
//             $('#emailCreate').val("");
//             $('#addressCreate').val("");
//             $('#province').val("0").change();
//             $('#district').val("0").change();
//             $('#ward').val("0").change();
//             $('#selectEmployee').val("0").change();
//
//
//         })
//         .fail((jqXHR) => {
//             console.log(jqXHR)
//         })
// });








