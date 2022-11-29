let customer = new Customer();
let locationRegionResult = new LocationRegionResult();

let locationRegionCreate = new LocationRegionCreate();

let employeeResult = new EmployeeResult();
let productResult = new ProductResult();
let orderResult = new OrderResult();
let orderItemResult = new OrderItemResult();
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
        console.log(" show(data) ");
        // searchCustomer();
    }

    if (customers !== undefined && customers.length > 0) {
        setTimeout(()=>{
            show(customers);
        },100)
        return;
    }
    $.ajax({
        type: "GET", contentType: 'application/json',
        url: `${location.origin}/api/customers/list_customer`
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
    console.log("searchCustomer");
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


function showCustomerInfo(idCustomer) {
    console.log(idCustomer);
    // $("#MuiBox-list-customer").addClass("hide");

    $("#idCustomer").val(idCustomer);
    let result = customer = customers.find(({id}) => id === idCustomer);
    console.log("resultt", result)

    let str = `<div class="MuiPaper-root jss938 MuiPaper-elevation1 MuiPaper-rounded" id="closed_customer_info">
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
                            <div class="MuiBox-root jss3899">${result.locationRegion.address}</p>
                            </div>
                        </div>
                        <div class="MuiBox-root jss3901 jss945 jss947">
                            <div class="MuiFormControl-root jss3914 jss3916 jss3911">
                                <div class="MuiFormControl-root MuiTextField-root jss3917" inputmode="numeric">
                                    <div class="MuiInputBase-root MuiInput-root MuiInput-underline MuiInputBase-formControl MuiInput-formControl">
                                        <input aria-invalid="false" autocomplete="off" name="lineItemQuantity-415457da-d825-4964-912f-10804128db81"
                                            type="text" class="MuiInputBase-input MuiInput-input" value="1"
                                            style="text-align: center; width: 100%;">
                                    </div>
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
                                    style="margin: 0 4px; height: 15px; min-width: unset;"><span
                                        class="MuiButton-label">Thay đổi</span><span
                                        class="MuiTouchRipple-root"></span>
                                </button>
                            </div>
                            <div class="MuiBox-root jss4278">
                                <p class="MuiTypography-root MuiTypography-body2">${result.phone}</p>
                                <p class="MuiTypography-root MuiTypography-body2">${result.locationRegion.address}</p>
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
// function showCustomerInfo(idCustomer) {
//     console.log(idCustomer);
//     // $("#MuiBox-list-customer").addClass("hide");
//
//     $("#idCustomer").val(idCustomer);
//     let result = customer = customers.find(({id}) => id === idCustomer);
//     console.log("resultt", result)
//
//     let str = `<div class="MuiPaper-root jss938 MuiPaper-elevation1 MuiPaper-rounded" id="closed_customer_info">
//         <div class="MuiBox-root jss985">
//             <div class="MuiBox-root jss3887 jss939">
//                 <div class="MuiBox-root jss3888">
//                     <h6 class="MuiTypography-root MuiTypography-h6" style="display: flex; align-items: center;"><svg
//                             class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true"
//                             style="color: rgb(163, 168, 175); font-size: 22px; margin-right: 10px;">
//                             <path
//                                 d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 3c1.66 0 3 1.34 3 3s-1.34 3-3 3-3-1.34-3-3 1.34-3 3-3zm0 14.2c-2.5 0-4.71-1.28-6-3.22.03-1.99 4-3.08 6-3.08 1.99 0 5.97 1.09 6 3.08-1.29 1.94-3.5 3.22-6 3.22z">
//                             </path>
//                         </svg>Thông tin khách hàng</h6>
//                     <div class="MuiBox-root jss3889"><a target="_blank" href="/admin/customers/181966855"
//                             style="text-decoration: none; display: inline-flex; align-items: center;">
//                             <h6 class="MuiTypography-root MuiTypography-h6 MuiTypography-colorPrimary"
//                                 title="Denise Zimmerman">${result.name}</h6>
//                             <h6 class="MuiTypography-root MuiTypography-h6 MuiTypography-colorTextPrimary">
//                                 &nbsp;-&nbsp;${result.phone}</h6>
//                         </a>
//                         <button
//                             class="MuiButtonBase-root MuiIconButton-root jss948 MuiIconButton-colorSecondary MuiIconButton-sizeSmall"
//                             tabindex="0"
//                             onclick="handleRemove()"
//                             type="button">
//                             <span class="MuiIconButton-label">
//                             <svg viewBox="0 0 24 24"
//                                     fill="none" xmlns="http://www.w3.org/2000/svg" width="20" height="20"
//                                     font-size="20">
//                                     <path
//                                         d="M19 6.41 17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12 19 6.41Z"
//                                         fill="currentColor"></path>
//                                 </svg>
//                                 </span>
//                                 <span class="MuiTouchRipple-root"></span>
//                                 </button>
//                                 </div>
//                 </div>
//             </div>
//             <div class="MuiBox-root jss3895 jss942">
//                 <div class="MuiBox-root jss3896 jss952">
//                     <div class="MuiBox-root jss3897">
//                         <div class="MuiBox-root jss3898 jss944">
//                             <div class="MuiBox-root jss3899">${result.locationRegion.address}</p>
//                             </div>
//                         </div>
//                         <div class="MuiBox-root jss3901 jss945 jss947">
//                             <div class="MuiFormControl-root jss3914 jss3916 jss3911">
//                                 <div class="MuiFormControl-root MuiTextField-root jss3917" inputmode="numeric">
//                                     <div class="MuiInputBase-root MuiInput-root MuiInput-underline MuiInputBase-formControl MuiInput-formControl">
//                                         <input aria-invalid="false" autocomplete="off" name="lineItemQuantity-415457da-d825-4964-912f-10804128db81"
//                                             type="text" class="MuiInputBase-input MuiInput-input" value="1"
//                                             style="text-align: center; width: 100%;">
//                                     </div>
//                             </div>
//                     </div>
//                         </div>
//                     </div>
//                     <div class="MuiBox-root jss4275">
//                         <div class="MuiBox-root jss4276 jss944">
//                             <div class="MuiBox-root jss4277">
//                                 <p class="MuiTypography-root jss941 MuiTypography-body2">Địa chỉ nhận hóa đơn</p>
//                                 <button
//                                     class="MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary"
//                                     tabindex="0"
//                                     onclick="editCustomer()"
//                                      type="button"
//                                     style="margin: 0 4px; height: 15px; min-width: unset;"><span
//                                         class="MuiButton-label">Thay đổi</span><span
//                                         class="MuiTouchRipple-root"></span>
//                                 </button>
//                             </div>
//                             <div class="MuiBox-root jss4278">
//                                 <p class="MuiTypography-root MuiTypography-body2">${result.phone}</p>
//                                 <p class="MuiTypography-root MuiTypography-body2">${result.locationRegion.address}</p>
//                             </div>
//                         </div>
//                         <div class="MuiBox-root jss4279 jss945">
//                             <div class="MuiBox-root jss4280">
//                                 <p class="MuiTypography-root jss941 MuiTypography-body2">Liên hệ</p>
//                             </div>
//                             <p class="MuiTypography-root MuiTypography-body2" style="color: rgb(163, 168, 175);">Chưa có
//                                 thông tin liên hệ</p>
//                             <div class="MuiFormControl-root jss1315 MuiFormControl-fullWidth"
//                                 style="padding-top: 16px;">
//                                 <div class="MuiFormControl-root MuiTextField-root jss1317 MuiFormControl-fullWidth">
//                                     <div
//                                         class="MuiInputBase-root MuiOutlinedInput-root MuiInputBase-fullWidth MuiInputBase-formControl">
//                                         <input aria-invalid="false" id="557fa869-3d86-41db-933d-de2fc27a08c6"
//                                             placeholder="Email" type="text" aria-label="Without label" maxlength="200"
//                                             class="MuiInputBase-input MuiOutlinedInput-input"
//                                             value=${result.email} >
//                                         <fieldset aria-hidden="true" class="jss1037 MuiOutlinedInput-notchedOutline"
//                                             style="padding-left: 8px;">
//                                             <legend class="jss1038" style="width: 0.01px;"><span>​</span></legend>
//                                         </fieldset>
//                                     </div>
//                                 </div>
//                             </div>
//                         </div>
//                     </div>
//                 </div>
//             </div>
//         </div>
//     </div>`;
//
//     $("#show_customer_info").html(str);
//
// }


function handleCloseListCustomers() {
    $(document).on("click", () => {
        $(".searchCustomer").addClass('d-none');
    })
}
function getAllItem() {
   return  $.ajax({
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
        contentType: 'application/json',
        url: `${location.origin}/api/products/show_list`
    })
        .done((data) => {
            products = data;
            console.log("data", data)
                $(".searchProduct").removeClass('d-none');
                $(".contentProduct div").remove();
                $.each(data, (i, product) => {
                    let result = `             
                    <div class="MuiBox-root jss3941 InfiniteScroll-MenuItem focus-key-event"
                    onclick="showProductInfo(${product.id})" data-id="${product.id}" tabindex="0">
                    <li class="MuiButtonBase-root MuiListItem-root MuiMenuItem-root jss1259 MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button" tabindex="-1" role="menuitem" aria-disabled="false">
                        <img class="jss1260" src="${product.image}" alt="">
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
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(0, 136, 255);">${itemResult.quantity}</span>
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(163, 168, 175);">&nbsp;| Có thể bán: </span>
                                            <span class="MuiTypography-root MuiTypography-body1" style="color: rgb(0, 136, 255);">${itemResult.available}</span>
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

//
// function doUpdateCustomer() {
//     $('#btnUpdateCustomer').on('click', (idCustomer ) => {
//         locationRegionResult.provinceId = $("#provinceUpdate").val();
//         locationRegionResult.provinceName = $("#provinceUpdate :selected").text();
//         locationRegionResult.districtId = $("#districtUpdate").val();
//         locationRegionResult.districtName = $("#districtUpdate :selected").text();
//         locationRegionResult.wardId = $("#wardUpdate").val();
//         locationRegionResult.wardName = $("#wardUpdate :selected").text();
//         locationRegionResult.address = $("#addressUpdate").val();
//         customer.id = $("#idCustomerUpdate").val();
//         customer.name = $("#nameUpdate").val();
//         customer.phone = $("#phoneUpdate").val();
//         customer.customerCode = $("#codeUpdate").val();
//         customer.locationRegionResult = locationRegionResult;
//
//         $.ajax({
//             "headers": {
//                 "accept": "application/json",
//                 "content-type": "application/json"
//             },
//             "type": "PUT",
//             "url": "http://localhost:8080/api/customers/update/" + idCustomer,
//             "data": JSON.stringify(customer)
//         })
//             .done((data) => {
//                 customer = data;
//                 customer.locationRegionResult = locationRegionResult;
//                 removeEventModal();
//                 $("#update_order_customer").modal("hide");
//                 App.IziToast.showSuccessAlert("Cập nhật khách hàng thành công!");
//             })
//             .fail((jqXHR) => {
//                 console.log(jqXHR);
//             })
//     });
//
// }
// doUpdateCustomer();

function showProductInfo(productId) {
    $('#MuiBox-list-product').addClass("hide");

    $("#productId").val(productId);
    let result = product = products.find(({id}) => id === productId);
    let str =`
        <table class="MuiTable-root MuiTable-stickyHeader table_product" aria-label="simple table" style="border-collapse: inherit;">
            <thead class="MuiTableHead-root">
                <tr class="MuiTableRow-root MuiTableRow-head">
                    <th class="MuiTableCell-root MuiTableCell-head MuiTableCell-alignCenter MuiTableCell-stickyHeader"
                        scope="col" style="width: 55px;">STT</th>
                    <th class="MuiTableCell-root MuiTableCell-head MuiTableCell-alignCenter MuiTableCell-stickyHeader"
                        scope="col" style="width: 60px;">Ảnh</th>
                    <th class="MuiTableCell-root MuiTableCell-head MuiTableCell-alignLeft MuiTableCell-stickyHeader"
                        scope="col">Tên sản phẩm</th>
                    <th class="MuiTableCell-root MuiTableCell-head MuiTableCell-alignCenter MuiTableCell-stickyHeader"
                        scope="col" style="width: 105px;">Số lượng</th>
                    <th class="MuiTableCell-root MuiTableCell-head MuiTableCell-alignRight MuiTableCell-stickyHeader"
                        scope="col" style="width: 115px;">Đơn giá</th>
                    <th class="MuiTableCell-root MuiTableCell-head MuiTableCell-alignRight MuiTableCell-stickyHeader"
                        scope="col" style="width: 115px;">Chiết khấu</th>
                    <th class="MuiTableCell-root MuiTableCell-head MuiTableCell-alignRight MuiTableCell-stickyHeader"
                        scope="col" style="width: 115px;">Thành tiền</th>
                    <th class="MuiTableCell-root MuiTableCell-head MuiTableCell-alignRight MuiTableCell-stickyHeader"
                        scope="col" style="width: 30px;"></th>
                </tr>
            </thead>
            <tbody class="MuiTableBody-root">
                <tr class="MuiTableRow-root jss3894 jss3905 isNormalLineItem">
                    <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignCenter">2</td>
                    <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignCenter"><a
                            class="MuiTypography-root MuiLink-root MuiLink-underlineNone MuiTypography-colorPrimary"
                            target="_blank" href="/admin/products/118801409/variants/185370765"><img class="jss3898"
                                src="https://sapo.dktcdn.net/100/676/770/variants/f1225b2e-790d-418d-9a35-86ff8a8ce807-1668993704051.jpg"></a>
                    </td>
                    <td class="MuiTableCell-root MuiTableCell-body">
                        <div class="MuiBox-root jss4053 jss3895">
                            <div class="MuiBox-root jss4054">
                                <div class="MuiBox-root jss4055">
                                    <p class="MuiTypography-root MuiTypography-body1">Sữa dưỡng thể Vaseline trắng da
                                        tức thì 350ml<button class="MuiButtonBase-root MuiIconButton-root" tabindex="0"
                                            type="button"
                                            style="padding: 0px; margin-left: 6px; height: fit-content;"><span
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
                                    style="font-weight: normal; margin: 2px 0px;">Mặc định</h6><a
                                    class="MuiTypography-root MuiLink-root MuiLink-underlineNone MuiTypography-colorPrimary"
                                    target="_blank" href="/admin/products/118801409/variants/185370765"><span
                                        class="MuiTypography-root MuiTypography-body1 MuiTypography-colorPrimary">PVN04</span></a><button
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
                    <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignCenter"
                        style="width: 105px; padding-left: 0px; padding-right: 0px;">
                        <div class="MuiBox-root jss4056 jss3910"><button
                                class="MuiButtonBase-root MuiIconButton-root jss3912 icon-btn btn-subtract auto-hidden"
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
                                            name="lineItemQuantity-415457da-d825-4964-912f-10804128db81" type="text"
                                            class="MuiInputBase-input MuiInput-input" value="1"
                                            style="text-align: center; width: 100%;"></div>
                                </div>
                            </div><button
                                class="MuiButtonBase-root MuiIconButton-root jss3912 icon-btn btn-add auto-hidden"
                                tabindex="0" type="button"><span class="MuiIconButton-label"><svg
                                        class="MuiSvgIcon-root MuiSvgIcon-fontSizeSmall" focusable="false"
                                        viewBox="0 0 24 24" aria-hidden="true">
                                        <path
                                            d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm5 11h-4v4h-2v-4H7v-2h4V7h2v4h4v2z">
                                        </path>
                                    </svg></span><span class="MuiTouchRipple-root"></span></button>
                        </div>
                    </td>
                    <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight">
                        <div class="MuiFormControl-root jss3914 jss3916" style="padding-top: 0px;">
                            <div class="MuiFormControl-root MuiTextField-root jss3917" inputmode="numeric"
                                data-for="tooltipTax-415457da-d825-4964-912f-10804128db81">
                                <div
                                    class="MuiInputBase-root MuiInput-root MuiInput-underline MuiInputBase-formControl MuiInput-formControl">
                                    <input aria-invalid="false" autocomplete="off"
                                        id="price-line-item-415457da-d825-4964-912f-10804128db81"
                                        name="input-price-415457da-d825-4964-912f-10804128db81" type="text"
                                        class="MuiInputBase-input MuiInput-input" value="160,000"
                                        style="width: 100%; text-align: right;"></div>
                            </div>
                        </div>
                    </td>
                    <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight"><button
                            class="MuiButtonBase-root MuiButton-root MuiButton-text jss3901" tabindex="0" type="button"
                            id="discount-line-item-415457da-d825-4964-912f-10804128db81"><span class="MuiButton-label">0
                                <p class="MuiTypography-root discount_rate_line_item MuiTypography-body1"
                                    style="color: rgb(255, 77, 77); font-size: 12px;"></p></span></button> </td>
                    <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight">160,000</td>
                    <td class="MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight" style="padding-left: 0px;">
                        <button
                            class="MuiButtonBase-root MuiIconButton-root MuiIconButton-colorSecondary MuiIconButton-sizeSmall"
                            tabindex="0" type="button"><span class="MuiIconButton-label"><svg viewBox="0 0 24 24"
                                    fill="none" xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                    font-size="20">
                                    <path
                                        d="M19 6.41 17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12 19 6.41Z"
                                        fill="currentColor"></path>
                                </svg></span><span class="MuiTouchRipple-root"></span></button></td>
                </tr>
            </tbody>
        </table>
    `;
    $("#show_product_info").html(str);
}

$(() => {
    getAllItem();
    getAllEmployees();
    searchCustomer();
    handleCloseListCustomers()
})



