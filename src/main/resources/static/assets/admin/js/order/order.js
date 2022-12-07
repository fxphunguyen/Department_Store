let customer = new Customer();
let locationRegionResult = new LocationRegionResult();
let locationRegionCreate = new LocationRegionCreate();
let employeeResult = new EmployeeResult();
let productResult = new ProductResult();
let order = new OrderResult();
let orderItem = new OrderItemResult();
let itemResult = new ItemResult();


let customers;

let products;

let employees = [];

function showListCustomer() {
    function show(data) {

        $(".searchCustomer").removeClass('d-none');
        $(".contentCustomer div").remove();
        $.each(data, (i, customer) => {
            let result = `
                <div class="MuiBox-root jss4978 InfiniteScroll-MenuItem focus-key-event showInfo" onclick="showCustomerInfo(${customer.id})"
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
        // searchCustomer();
    }

    if (customers !== undefined && customers.length > 0) {
        setTimeout(() => {
            show(customers);
        }, 100)
        return;
    }
    $.ajax({
        type: "GET", contentType: 'application/json',
        url: `${location.origin}/api/customers/list_customerAll`
    })
        .done((data) => {
            customers = data;
            show(data);
        })
        .fail((jqXHR) => {
            console.log(jqXHR)
        })
}

const searchCustomer = () => {
    // console.log("searchCustomer");
    $("#myInput").on("input", function () {
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
                <div class="MuiBox-root jss4978 InfiniteScroll-MenuItem focus-key-event showInfo"  onclick="showCustomerInfo(${customer.id})"
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
    })
}

const searchProduct = () => {
    $("#input_product").on("input", function () {
        let search = $(this).val();
        let results = [];
        products.forEach((item) => {
            if (((item.title).toLowerCase()).includes(search.toLowerCase()) || ((item.sku).toLowerCase()).includes(search.toLowerCase())
                || ((item.bar_code).toLowerCase()).includes(search.toLowerCase()) || ((item.description).toLowerCase()).includes(search.toLowerCase())) {
                results.push(item);
            }
        })
        $(".searchProduct").removeClass('d-none');
        $(".contentProduct div").remove();
        $.each(results, (i, product) => {
            let result = `
                      <div class="MuiBox-root jss3941 InfiniteScroll-MenuItem focus-key-event"
                    onclick="showProductInfo(${product.id})" data-id="${product.id}" tabindex="0">
                    <li class="MuiButtonBase-root MuiListItem-root MuiMenuItem-root jss1259 MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button" tabindex="-1" role="menuitem" aria-disabled="false">
                        <img class="jss1260" src="${product.image}" alt="">
                            <div class="MuiBox-root jss3946">
                                <div class="MuiBox-root jss3947">
                                    <p class="MuiTypography-root MuiTypography-body1" style="white-space: break-spaces;">${product.title} - ${product.bar_code} - ${product.description} </p>
                                        <p class="MuiTypography-root MuiTypography-body2" style="line-height: 16px; display: flex;">
                                        <span class="MuiTypography-root MuiTypography-body2" style="color: rgb(163, 168, 175); line-height: 16px;"> ${product.sku} </span>
                                        <span class="MuiTypography-root jss1258 MuiTypography-body2 MuiTypography-colorPrimary" title="Mặc định">${product.description}</span>
                                    </p>
                                </div>
                                <div class="MuiBox-root jss3953">
                                    <h6 class="MuiTypography-root MuiTypography-h6">${product.retail_price} 
</h6>
                                        <p class="MuiTypography-root MuiTypography-body1" style="margin-top: 4px;">
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(163, 168, 175);">Tồn:  </span>
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(0, 136, 255);">${product.quantity}</span>
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(163, 168, 175);">&nbsp;| Có thể bán: </span>
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(0, 136, 255);">${product.available}</span>
                                        </p>
                                </div>
                            </div>
                        <span class="MuiTouchRipple-root"></span>
                    </li>
                </div>    
                `;
            $(".contentProduct").append(result);
        })
    })
}


function showCustomerInfo(idCustomer) {
    // $("#MuiBox-list-customer").addClass("hide");
    $("#idCustomer").val(idCustomer);
    let result = customer = customers.find(({id}) => id === idCustomer);
    let shippingAddress = result.shippingAddress;
    let fullShippingAddress = "";
    if (shippingAddress.line1 != null)
        fullShippingAddress = `${shippingAddress.line1}, `;
    if (shippingAddress.line2 != null)
        fullShippingAddress += `${shippingAddress.line2}, `;
    if (shippingAddress.wardName != null)
        fullShippingAddress += `${shippingAddress.wardName}, `;
    if (shippingAddress.districtName != null)
        fullShippingAddress += `${shippingAddress.districtName}, `;
    if (shippingAddress.provinceName != null)
        fullShippingAddress += `${shippingAddress.provinceName}`;

    let billAddress = result.billAddress;
    let fullBillAddress= "";
    if (billAddress.line1 != null)
        fullBillAddress = `${billAddress.line1}, `;
    if (billAddress.line2 != null)
        fullBillAddress += `${billAddress.line2}, `;
    if (billAddress.wardName != null)
        fullBillAddress += `${billAddress.wardName}, `;
    if (billAddress.districtName != null)
        fullBillAddress += `${billAddress.districtName}, `;
    if (billAddress.provinceName != null)
        fullBillAddress += `${billAddress.provinceName}`;


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
            <hr/>
            <div class="MuiBox-root jss3895 jss942">
                <div class="MuiBox-root jss3896 jss952">
                    <div class="MuiBox-root jss3897">
                        <div class="MuiBox-root jss3898 jss944">
                            <div class="MuiBox-root jss3899">
                                <p class="MuiTypography-root jss941 MuiTypography-body2">Địa chỉ giao hàng</p>
                                <button class="MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary" tabindex="0" type="button" style="margin: 0px 4px; height: 15px; min-width: unset;">
                                <span class="MuiButton-label">Thay đổi</span>
                                <span class="MuiTouchRipple-root"></span>
                                </button>
                            </div>
                            <div class="MuiBox-root jss3900">
                                <p class="MuiTypography-root MuiTypography-body2">${result.phone}</p>
                                <p class="MuiTypography-root MuiTypography-body2">${fullShippingAddress}</p>
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
                    <div class="MuiBox-root jss4275">
                        <div class="MuiBox-root jss4276 jss944">
                            <div class="MuiBox-root jss4277">
                                <p class="MuiTypography-root jss941 MuiTypography-body2">Địa chỉ nhận hóa đơn</p>
                                <button
                                    class="MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary"
                                    tabindex="0"
                                    onclick="editCustomer()"
                                     type="button"
                                    style="margin: 0 4px; height: 15px; min-width: unset;"><span
                                        class="MuiButton-label">Thay đổi</span><span
                                        class="MuiTouchRipple-root"></span>
                                </button>
                            </div>
                            <div class="MuiBox-root jss4278">
                                <p class="MuiTypography-root MuiTypography-body2">${result.phone}</p>
                                <p class="MuiTypography-root MuiTypography-body2">${fullBillAddress}</p>
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

function getAllItem() {
    return $.ajax({
        type: "GET",
        contentType: 'application/json',
        url: `${location.origin}/api/items/variants`
    })
        .done((data) => {
            items = data;
        })
        .fail((jqXHR) => {
            console.log(jqXHR);
        })
}

function showListProducts() {
    $.ajax({
        type: "GET",
        // contentType: 'application/json',
        url: `${location.origin}/api/products/showProductInfo`
    })
        .done((data) => {
            products = data;
            $(".searchProduct").removeClass('d-none');
            $(".searchProduct").removeClass('hide').addClass('show');

            $(".contentProduct div").remove();
            $.each(data, (i, product) => {
                let result = `             
                    <div class="MuiBox-root jss3941 InfiniteScroll-MenuItem focus-key-event"
                    onclick="showProductInfo(${product.id})" data-id="${product.id}" tabindex="0">
                    <li class="MuiButtonBase-root MuiListItem-root MuiMenuItem-root jss1259 MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button" tabindex="-1" role="menuitem" aria-disabled="false">
                        <img class="jss1260" src="${product.image}" alt="">
                            <div class="MuiBox-root jss3946">
                                <div class="MuiBox-root jss3947">
                                    <p class="MuiTypography-root MuiTypography-body1" style="white-space: break-spaces;">${product.title} - ${product.bar_code} - ${product.description} </p>
                                        <p class="MuiTypography-root MuiTypography-body2" style="line-height: 16px; display: flex;">
                                    
                                        <span class="MuiTypography-root MuiTypography-body2" style="color: rgb(163, 168, 175); line-height: 16px;"> ${product.sku} </span>
                                        <span class="MuiTypography-root jss1258 MuiTypography-body2 MuiTypography-colorPrimary" title="Mặc định">${product.description}</span>
                                    </p>
                                </div>
                                <div class="MuiBox-root jss3953">
                                    <h6 class="MuiTypography-root MuiTypography-h6">${(product.retail_price).formatVND()}</h6>
                                        <p class="MuiTypography-root MuiTypography-body1" style="margin-top: 4px;">
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(163, 168, 175);">Tồn:  </span>
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(0, 136, 255);">${product.quantity}</span>
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(163, 168, 175);">&nbsp;| Có thể bán: </span>
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(0, 136, 255);">${product.available}</span>
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
            if (data.results.length === 0) {
                let str = `<option value="0">Chọn Tỉnh/Thành Phố</option>`;
                $("#province").append(str);
            } else {
                $.each(data.results, (i, item) => {
                    let str = `<option value="${item.province_id}">${item.province_name}</option>`;
                    $("#province").append(str);
                    $('#provinceUpdate').append(str);
                });
            }

        })
        .fail((jqXHR) => {
            console.log(jqXHR);
        })
}

function getAllDistrictsByProvinceId(provinceId) {
    $("#district").empty();
    $("#districtUpdate").empty();
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
            } else {
                $.each(data.results, (i, item) => {
                    let str = ` <option value="${item.district_id}">${item.district_name}</option>`;
                    $("#district").append(str);
                    $('#districtUpdate').append(str);
                })

            }
        })
        .fail((jqXHR) => {
            console.log(jqXHR);
        })
}

function getAllWardsByDistrictId(districtId) {
    $("#ward").empty();
    $('#wardUpdate').empty();
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

            } else {
                $.each(data.results, (i, item) => {
                    let str = `<option value="${item.ward_id}">${item.ward_name}</option>`;
                    $("#ward").append(str);
                    $('#wardUpdate').append(str);
                });
            }
        })
        .fail((jqXHR) => {
            console.log(jqXHR);
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

$("#provinceUpdate").on("change", () => {
    let provinceId = $("#provinceUpdate").val();
    getAllDistrictsByProvinceId(provinceId).then(() => {
        let districtId = $("#districtUpdate").val();
        getAllWardsByDistrictId(districtId);
    })
})

$("#districtUpdate").on("change", () => {
    let districtId = $("#districtUpdate").val();
    getAllWardsByDistrictId(districtId);
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
            employeeResult = data;
            $.each(data, (i, item) => {
                let str = `<option value="${item.id}">${item.name}</option>`;
                $("#selectEmployee").append(str);
                $("#selectEmployeeUpdate").append(str);
            });
            // }
        })
        .fail((jqXHR) => {
            console.log(jqXHR)
        })
}


function doCreateCustomer() {
    $('#btnCreateCustomer').on('click', () => {
        customer.name = $('#nameCreate').val();
        customer.customerCode = $('#codeCreate').val();
        customer.phone = $('#phoneCreate').val();
        customer.locationRegionCreate = locationRegionCreate;
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
            "url": `${location.origin}/api/customers/create`,
            "data": JSON.stringify(customer)
        })
            .done((data) => {
                customer = data;
                customer.locationRegionCreate = locationRegionCreate;
                $("#create_order_customer").modal("hide");
                App.IziToast.showSuccessAlert("Thêm khách hàng thành công!");
                searchCustomer();
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

}

doCreateCustomer();


function handleRemove() {
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
    searchCustomer();
}

function getCustomerById(idCustomer) {
    return $.ajax({
        headers: {
            accept: "application/json",
            "content-type": "application/json"
        },
        type: "GET",
        url: `${location.origin}/api/customers/` + idCustomer
    })
        .done((data) => {
            customer = data;
        })
        .fail((jqXHR) => {
            console.log(jqXHR);
        })
}

function getAllEmployees() {
    return $.ajax({
        headers: {
            accept: "application/json",
            "content-type": "application/json"
        },
        type: "GET",
        url: `${location.origin}/api/employees/show_list/`
    })
        .done((data) => {
            employeeResult = data;
            $.each(data, (i, item) => {
                let str = `<option value="${item.id}">${item.name}</option>`;
                $("#selectEmployee").append(str);
                $("#selectEmployeeUpdate").append(str);
            })

        })
        .fail((jqXHR) => {
            console.log(jqXHR);
        })
}

function editCustomer() {
    let id = $("#idCustomer").val();
    $('#idCustomerUpdate').val(customer.id);
    $("#nameUpdate").val(customer.name)
    $('#phoneUpdate').val(customer.phone);
    $('#addressUpdate').val(customer.locationRegionResult.address);
    $('#provinceUpdate').val(customer.locationRegionResult.provinceId);
    getAllDistrictsByProvinceId(customer.locationRegionResult.provinceId).then(() => {
        $("#districtUpdate").val(customer.locationRegionResult.districtId);
        getAllWardsByDistrictId(customer.locationRegionResult.districtId).then(() => {
            $("#wardUpdate").val(customer.locationRegionResult.wardId);


        })
    })
    $("#codeUpdate").val(customer.customerCode);
    $("#selectEmployeeUpdate").val(customer.employeeId);

    $("#update_order_customer").modal("show");
}


function showProductInfo(productId) {
    $('#MuiBox-list-product').addClass("hide");
    $("#productId").val(productId);

    let result = product = products.find(({id}) => id === productId);
    let taxText;
    let tax = result.tax;
    let retailPrice = result.retail_price;
    taxText = (retailPrice * (tax / 100));
    let std = `
            <div >
            <div class="MuiListItemText-root" style="float:left">                                        
                <span class="MuiTypography-root MuiListItemText-primary MuiTypography-body1 MuiTypography-displayBlock" id="tax_${result.id}">VAT(${result.tax}%)</span>
            </div>
            <div class="MuiListItemText-root" style="float:right">
                <span class="MuiTypography-root MuiListItemText-primary MuiTypography-body1 MuiTypography-alignRight MuiTypography-displayBlock" id="tax_value_${result.id}">0</span>
            </div>
            <div style="clear: both"></div>
            </div>
    `;
    $("#ul_vat_tax").prepend(std);
    let str = `
        <tr id="tr_${result.id}" class="MuiTableRow-root jss3894 jss3905 isNormalLineItem">
            <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignCenter align-items-center">${result.id}</td>
            <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignCenter align-items-center"><a
                    class="MuiTypography-root MuiLink-root MuiLink-underlineNone MuiTypography-colorPrimary align-items-center"
                    target="_blank" href="/admin/products/118801409/variants/185370765"><img class="jss3898"
                        src=${result.image} alt="Sản phẩm"></a>
            </td>
            <td class="MuiTableCell-root MuiTableCell-body align-items-center">
                <div class="MuiBox-root jss4053 jss3895 ">
                    <div class="MuiBox-root jss4054">
                        <div class="MuiBox-root jss4055">
                            <p class="MuiTypography-root MuiTypography-body1">${result.title}<button class="MuiButtonBase-root MuiIconButton-root" tabindex="0"
                                    type="button"
                                    style="padding: 0; margin-left: 6px; height: fit-content;"><span
                                        class="MuiIconButton-label"><svg viewBox="0 0 16 16" fill="none"
                                            xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            font-size="16"
                                            style="font-size: 16px; margin-top: -5px; cursor: pointer; color: rgb(0, 136, 255);">
                                            <path
                                                d="M7.4 5v1.2h1.2V5H7.4ZM7.4 8.6V11h1.8V9.8h-.6V7.4H6.8v1.2h.6Z"
                                                fill="currentColor"></path>
                                            <path fill-rule="evenodd" clip-rule="evenodd"
                                                d="M8 2C4.688 2 2 4.688 2 8s2.688 6 6 6 6-2.688 6-6-2.688-6-6-6ZM3.2 8c0 2.646 2.154 4.8 4.8 4.8s4.8-2.154 4.8-4.8S10.646 3.2 8 3.2A4.806 4.806 0 0 0 3.2 8Z"
                                                fill="currentColor"></path>
                                        </svg></span><span class="MuiTouchRipple-root"></span></button></p>
                        </div>
                        <h6 class="MuiTypography-root MuiTypography-subtitle2 MuiTypography-colorTextSecondary"
                            style="font-weight: normal; margin: 2px 0;">${result.description}</h6><a
                            class="MuiTypography-root MuiLink-root MuiLink-underlineNone MuiTypography-colorPrimary"
                            target="_blank" href="/admin/products/118801409/variants/185370765"><span
                                class="MuiTypography-root MuiTypography-body1 MuiTypography-colorPrimary">${result.sku}</span></a><button
                            class="MuiButtonBase-root MuiButton-root MuiButton-text jss3896 btn-hover MuiButton-textPrimary MuiButton-textSizeSmall MuiButton-sizeSmall"
                            tabindex="0" type="button"><span class="MuiButton-label"><span
                                    class="MuiButton-startIcon MuiButton-iconSizeSmall"><svg viewBox="0 0 24 24"
                                        fill="none" xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                        font-size="20" color="primary">
                                        <path
                                            d="M19 3H5c-1.103 0-2 .897-2 2v16l4.8-3.6A2 2 0 0 1 9 17h10c1.103 0 2-.897 2-2V5c0-1.103-.897-2-2-2Zm0 12H8.334a2 2 0 0 0-1.2.4L5 17V5h14v10Z"
                                            fill="#0088FF"></path>
                                        <path d="M9 9h6v2H9V9Z" fill="#0088FF"></path>
                                    </svg></span>Ghi chú</span><span
                                class="MuiTouchRipple-root"></span></button>
                    </div>
                </div>
            </td>
            <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignCenter "
                style="width: 105px; padding-left: 0px; padding-right: 0px;">
                <div class="MuiBox-root jss4056 jss3910"><button 
                        class="MuiButtonBase-root MuiIconButton-root jss3912 icon-btn btn-subtract auto-hidden" onclick="minusQuantity(${result.id})"
                         id="minusQuantity_${result.id}"
                        tabindex="0" type="button"><span class="MuiIconButton-label"><svg
                                class="MuiSvgIcon-root MuiSvgIcon-fontSizeSmall" focusable="false"
                                viewBox="0 0 24 24" aria-hidden="true">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm5 11H7v-2h10v2z">
                                </path>
                            </svg></span><span class="MuiTouchRipple-root"></span></button>
                    <div class="MuiFormControl-root jss3914 jss3916 jss3911">
                        <div class="MuiFormControl-root MuiTextField-root jss3917" inputmode="numeric">
                            <div
                                class="MuiInputBase-root MuiInput-root MuiInput-underline MuiInputBase-formControl MuiInput-formControl">
                                <input aria-invalid="false" autocomplete="off"
                                    name="" type="text"
                                    class="MuiInputBase-input MuiInput-input" value="1"
                                    style="text-align: center; width: 100%;"
                                    id="quantity_product_${result.id}">
                                </div>
                        </div>
                    </div><button
                        class="MuiButtonBase-root MuiIconButton-root jss3912 icon-btn btn-add auto-hidden" onclick="addQuantity(${result.id})"
                         id="addQuantity_${result.id}"
                        tabindex="0" type="button"><span class="MuiIconButton-label"><svg
                                class="MuiSvgIcon-root MuiSvgIcon-fontSizeSmall" focusable="false"
                                viewBox="0 0 24 24" aria-hidden="true">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm5 11h-4v4h-2v-4H7v-2h4V7h2v4h4v2z">
                                </path>
                            </svg></span><span class="MuiTouchRipple-root"></span></button>
                </div>
            </td>
            <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight align-items-center">
                <div class="MuiFormControl-root jss3914 jss3916" style="padding-top: 0px;">
                    <div class="MuiFormControl-root MuiTextField-root jss3917" inputmode="numeric"
                        data-for="tooltipTax-415457da-d825-4964-912f-10804128db81">
                        <div
                            class="MuiInputBase-root MuiInput-root MuiInput-underline MuiInputBase-formControl MuiInput-formControl">
                            <input aria-invalid="false" autocomplete="off"
                                id="retail_price_${result.id}"
                                name="" type="text"
                                class="MuiInputBase-input MuiInput-input" value=${result.retail_price}
                                                                 
                                style="width: 100%; text-align: right"
                                ></div>
                    </div>
                </div>
            </td>
            <td id="td-discount-${result.id}" class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight show_discount">
                <button data-product-discount-id="${result.id}"
                    class="MuiButtonBase-root MuiButton-root MuiButton-text jss3901 btn-discount dropdown-toggle" 
                    tabindex="0" 
                        data-bs-auto-close="outside" 
                    type="button"
                         id="dropdownMenuButton1_${result.id}" data-bs-toggle="dropdown" aria-expanded="false"
                    >
                    <span class="MuiButton-label" id="discount_value_${result.id}">0</span>
                        <p class="MuiTypography-root discount_rate_line_item MuiTypography-body1" id="percent_value_${result.id}"
                            style="color: rgb(255, 77, 77); font-size: 12px;">    
                        </p>
                </button>
              <div  aria-labelledby="dropdownMenuButton1" class="dropdown-menu MuiPaper-root jss1041 MuiPaper-elevation3 MuiPaper-rounded hidden_discount"
                style="width: 190px;position: absolute;margin-left: -37px;"
                data-popper-reference-hidden="false" data-popper-escaped="false" data-popper-placement="bottom">
                <div id="arrow" style="position: absolute;left: 0px;transform: translate(95px, 0px);"></div>
                <div class="MuiBox-root jss4417">
                    <div class="MuiBox-root jss4418">
                        <div class="MuiBox-root jss4419">
                            <div class="MuiToggleButtonGroup-root jss1283" role="group">
                            <button onclick="valueDiscount(event)"
                                    class="MuiButtonBase-root MuiToggleButton-root MuiToggleButtonGroup-grouped Mui-selected "
                                    tabindex="0" type="button" value="VALUE" aria-pressed="true">
                                    <span class="MuiToggleButton-label">Giá trị</span>
                                    <span class="MuiTouchRipple-root"></span>
                            </button>
                            <button onclick="valueDiscount(event)"
                                    class="MuiButtonBase-root MuiToggleButton-root MuiToggleButtonGroup-grouped" tabindex="0"
                                    type="button" value="PERCENT" aria-pressed="false"><span
                                        class="MuiToggleButton-label">%</span><span class="MuiTouchRipple-root"></span>
                            </button>
                            </div>
                            <div class="MuiFormControl-root jss4241 jss4243 jss1284" style="width: 92px; margin-left: 7px;">
                                <div class="MuiFormControl-root MuiTextField-root jss4244" inputmode="numeric">
                                    <div
                                        class="MuiInputBase-root MuiInput-root MuiInput-underline MuiInputBase-formControl MuiInput-formControl">
                                        <input id="discount_product_input_${result.id}"
                                               aria-invalid="false" 
                                               autocomplete="off" 
                                               name="numonly"
                                               type="text" 
                                               class="MuiInputBase-input MuiInput-input" value="0"
                                               onkeyup="formatDiscount(event,${result.id},${result.retail_price})"
                                               style="width: 100%; text-align: right;">
                                    </div>
                                             <!--oninput="onInputDiscount(event,${result.id},${result.retail_price})"-->
                                </div>
                            </div>
                        </div>
                    </div>   
                 </td>
            <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight " >
                <span id="amount_product_${result.id}" data-value="${product.retail_price}" >${result.retail_price}
                </span>
            </td>
                <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight " style="padding-left: 0px;">
                <button
                    class="MuiButtonBase-root MuiIconButton-root MuiIconButton-colorSecondary MuiIconButton-sizeSmall"
                    tabindex="0" type="button"><span class="MuiIconButton-label"><svg viewBox="0 0 24 24"
                            onclick="removeProduct(${result.id})"
                            fill="none" xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                            font-size="20">
                            <path
                                d="M19 6.41 17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12 19 6.41Z"
                                fill="currentColor"></path>
                        </svg></span><span class="MuiTouchRipple-root"></span></button></td>
        </tr>
    `;
    $("#tbProduct tbody").prepend(str);
    $("#divNoInfo").remove();
    $("#divTbProduct").removeClass("hide");
    handleGrandTotal();
    $("#vat_tax").removeClass('d-none');
    $(`#tax_value_${result.id}`).text(taxText.formatVND());
    handleGrandTotal();
}

function removeProduct(id) {
    if (id === undefined) {
        $("#divNoInfo").removeClass('hide').addClass('show');
        $("#vat_tax").remove();

    }
    $("#tr_" + id).remove();
}

function discountProduct(event) {
    let productId = event.target.parentElement.getAttribute("data-product-discount-id");
    let str = `
                <div class="MuiPaper-root jss1041 MuiPaper-elevation3 MuiPaper-rounded hidden_discount"
                style="width: 190px;position: absolute;margin-left: -37px;"
                data-popper-reference-hidden="false" data-popper-escaped="false" data-popper-placement="bottom">
                <div id="arrow" style="position: absolute;left: 0px;transform: translate(95px, 0px);"></div>
                <div class="MuiBox-root jss4417">
                    <div class="MuiBox-root jss4418">
                        <div class="MuiBox-root jss4419">
                            <div class="MuiToggleButtonGroup-root jss1283" role="group"><button
                                    class="MuiButtonBase-root MuiToggleButton-root MuiToggleButtonGroup-grouped Mui-selected" id="value_discount_${productId}" 
                                    tabindex="0" type="button" value="VALUE" aria-pressed="true"><span
                                        class="MuiToggleButton-label">Giá trị</span><span
                                        class="MuiTouchRipple-root"></span></button>
                                        <button
                                    class="MuiButtonBase-root MuiToggleButton-root MuiToggleButtonGroup-grouped" tabindex="0" id="rate_discount_${productId}"
                                    type="button" value="PERCENT" aria-pressed="false"><span
                                        class="MuiToggleButton-label">%</span><span class="MuiTouchRipple-root"></span></button>
                            </div>
                            <div class="MuiFormControl-root jss4241 jss4243 jss1284" style="width: 92px; margin-left: 7px;">
                                <div class="MuiFormControl-root MuiTextField-root jss4244" inputmode="numeric">
                                    <div
                                        class="MuiInputBase-root MuiInput-root MuiInput-underline MuiInputBase-formControl MuiInput-formControl">
                                        <input id="discount_product_input" aria-invalid="false" autocomplete="off" name="c2d2892e-316b-4ed0-aee6-1744e98c2a78"
                                            type="text" class="MuiInputBase-input MuiInput-input" value="0"
                                            style="width: 100%; text-align: right;">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>   
    `;
    $(`#td-discount-${productId}`).append(str);
}

const addQuantity = (productId) => {
    const discount = +$(`#discount_value_${productId}`).text().replaceAll(",", "");
    let quantityProduct = +($(`#quantity_product_${productId}`).val());
    quantityProduct = quantityProduct + 1;
    $(`#quantity_product_${productId}`).val(quantityProduct);
    let tax = $(`#tax_${productId}`).text().replaceAll("VAT", "").replaceAll(")", "").replaceAll("%", "").replaceAll("(", "");
    let retailProduct = +$(`#retail_price_${productId}`).val();
    let amount = (retailProduct - discount) * quantityProduct;
    let taxValue = (retailProduct * (tax / 100)) * quantityProduct;
    $(`#tax_value_${productId}`).text(taxValue.formatVND());
    $(`#amount_product_${productId}`).text(amount.formatVND());
    handleGrandTotal();
}

function minusQuantity(productId) {
    let quantityProduct = Number($(`#quantity_product_${productId}`).val());
    const discount = +$(`#discount_value_${productId}`).text().replaceAll(",", "");
    let tax = $(`#tax_${productId}`).text().replaceAll("VAT", "").replaceAll(")", "").replaceAll("%", "").replaceAll("(", "");
    quantityProduct = quantityProduct - 1;
    const retailProduct = +$(`#retail_price_${productId}`).val();
    let amount = (retailProduct - discount) * quantityProduct;
    let taxValue = (retailProduct * (tax / 100)) * quantityProduct;
    $(`#tax_value_${productId}`).text(taxValue.formatVND());
    $(`#amount_product_${productId}`).text(amount.formatVND());

    if (quantityProduct === 0) {
        Swal.fire({
            text: "Bạn chắc chắn muốn bỏ sản phẩm này ra khỏi đơn hàng không?",
            icon: 'warning',
            showCancelButton: true,
            cancelButtonText: "Hủy",
            confirmButtonColor: '#d33',
            confirmButtonText: 'Đồng ý'
        }).then((result) => {
            if (result.isConfirmed) {
                removeProduct(productId);
            }
        })
    }
    $(`#quantity_product_${productId}`).val(quantityProduct);
    handleGrandTotal();
}

function handleGrandTotal(productId) {
    let total = 0;
    let grandTotal = 0;
    let totalQuantity = 0;
    let totalTax = 0;
    $("#tbProduct tbody tr").each(function () {
        let rowId = $(this).attr("id").replaceAll("tr_", "");
        let item = +$("#amount_product_" + rowId).text().replaceAll(",", "");
        let qty = +$("#quantity_product_" + rowId).val();
        let taxs = +$("#tax_value_" + rowId).text().replaceAll(",", "");
        totalTax += taxs;
        totalQuantity += qty;
        total += item;
        grandTotal = total + totalTax;
        $("#quantity_products").text("Tổng tiền (" + totalQuantity + " sản phẩm)");
        $("#grandTotal").text(total.formatVND());
        $("#total_amounts").text(grandTotal.formatVND());
        $("#total_customer").text(grandTotal.formatVND());
    })
}

function removeProduct(productId) {
    $("#tr_" + productId).remove();
    iziToast.success({
        title: 'OK',
        position: 'bottomLeft',
        timeout: 1500,
        message: 'Xóa sản phẩm khỏi đơn hàng thành công!'
    });
    $(`#tax_id_${productId}`).remove();
    $("#vat_tax").addClass('d-none');
}

const valueDiscount = (event) => {
    const classList = [...event.target.parentElement.classList] || [];
    const muiSelecteds = event.target.parentElement.parentElement.children;
    const muis = [...muiSelecteds];
    if (classList.includes("Mui-selected")) {
        return;
    }
    muis.forEach((mui, index) => {
        if (mui) {
            mui.classList.remove("Mui-selected");
        }
    })
    event.target.parentElement.classList.add("Mui-selected");
}

const formatDiscount = (event, productId, retailPrice) => {
    $("#discount_product_input").on('keyup', function () {
        var n = parseInt($(this).val().replace(/\D/g, ''), 10);
        $(this).val(n.toLocaleString());
    });
    event.target.value = event.target.value.replace(/[^0-9]/g, '');
    const btnValueSelectors = event.target.parentElement.parentElement.parentElement.parentElement.children[0].children;
    console.log(btnValueSelectors, "btn")
    const btnValue = [...btnValueSelectors];
    btnValue.forEach((mui, index) => {
        const classLists = [...mui.classList];
        if (classLists.includes("Mui-selected")) {
            const valueInput = event.target.value;
            const quantity = document.querySelector(`#quantity_product_${productId}`).value;
            const total = retailPrice * quantity;
            let totalAfterDiscount, percentValue, discount;
            if (mui.value === "VALUE") {
                totalAfterDiscount = (retailPrice - valueInput) * quantity;
                percentValue = (valueInput * 100) / total;
                discount = total - totalAfterDiscount;

            } else {
                discount = total * (valueInput / 100);
                percentValue = valueInput;
                totalAfterDiscount = total - discount;
            }

            $(`#discount_value_${productId}`).text(discount.formatVND());
            $(`#percent_value_${productId}`).text(percentValue.toFixed(2) + "%");
            $(`#amount_product_${productId}`).text(totalAfterDiscount.formatVND());
        }
    })
    handleGrandTotal();
}

function numberOnly() {
    $("input[name='numonly']").on('input', function (e) {
        $(this).val($(this).val().replace(/[^0-9]/g, ''));
    });
};

// const createOrder = () => {
//
//     $("#btn_create_order").on('click', () => {
//         order.customerId = $(".showInfo").val();
//         order.employeeId = $(".searchEmployee").val();
//         order.discount = $("#discount_product").val();
//         order.description = $("")
//     })
//
//     $.ajax({
//             "headers": {
//                 "accept": "application/json",
//                 "content-type": "application/json"
//             },
//             "type": "POST",
//             "url": `${location.origin}/api/orders/create`,
//             "data": JSON.stringify(order)
//         })
//             .done((data) => {
//                 order = data;
//                 // order.orderItemResult = orderItem;
//                 // App.IziToast.showSuccessAlert("Thêm khách hàng thành công!");
//                 // searchCustomer();
//                 // $('#nameCreate').val("");
//                 // $('#codeCreate').val("");
//                 // $('#phoneCreate').val("");
//                 // $('#emailCreate').val("");
//                 // $('#addressCreate').val("");
//                 // $('#province').val("0").change();
//                 // $('#district').val("0").change();
//                 // $('#ward').val("0").change();
//                 // $('#selectEmployee').val("0").change();
//             })
//             .fail((jqXHR) => {
//                 console.log(jqXHR)
//             })
//
// }
// createOrder();
// function hiddenDiscount() {
//     $(document).on("click", () => {
//         $(".hidden_discount").removeClass('show').addClass('hide');
//     })
// }
// hiddenDiscount();
// window.onclick = function(event) {
//     //discount_product
//     if (!event.target.matches('.hidden_discount')&&!event.target.matches('#discount_product')) {
//         $(".hidden_discount").addClass("d-none");
//     }
// }

$(() => {
    getAllItem();
    getAllEmployees();
    searchCustomer();
    searchProduct();
    handleCloseListCustomers()
    handleCloseListProducts();
    searchProduct();
    numberOnly();
})




