function showListCustomer() {
    $.ajax({
        type: "GET", contentType: 'application/json',
        url: `${location.origin}/api/customers/list_customer`
    })
        .done((data) => {
            // console.log(data)
            $(".searchCustomer").removeClass('d-none');
            $(".contentCustomer div").remove();
            $.each(data, (i, customer) => {
                let result = `
                <div class="MuiBox-root jss4978 InfiniteScroll-MenuItem focus-key-event" key-event="true" onclick="showCustomerInfo(${customer.id})"
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

// function showCustomerInfo(idCustomer) {
//     $(".customer_info").removeClass("show").addClass("hide");
//     $(".customer_info_detail").remove("hide").addClass("show");
// }
// showProductInfo();

function handleCloseListCustomers() {
    $(document).on("click", () => {
        // $(".contentCustomer div").empty();
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
            console.log(data)
            $.each(data.results, (i, item) => {
                let str = `<option value="${item.province_id}">${item.province_name}</option>`;
                $("#province").append(str);
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
            console.log(data);
                if (data.results.length === 0) {
                    let str = `<option value="0">Chọn Quận/Huyện</option>`;
                    $("#district").append(str);
                } else {
                    $.each(data.results, (i, item) => {
                        let str = ` <option value="${item.district_id}">${item.district_name}</option>`;
                        $("#district").append(str);
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
            console.log("districtId", districtId)
            if (data.results.length === 0) {
                let str = `<option value="0">Chọn Phường/Xã</option>`;
                $("#ward").append(str);
            } else {
                $.each(data.results, (i, item) => {
                    let str = `<option value="${item.ward_id}">${item.ward_name}</option>
                                `;
                    $("#ward").append(str);
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
    getAllDistrictsByProvinceId(provinceId).done(()=>{
        let districtId = $("#district").val();
        getAllWardsByDistrictId(districtId);
    })

    $("#district").on('change', () => {
        let districtId = $("#district").val();
        getAllWardsByDistrictId(districtId);
    })
});

function getAllEmployeeSelect() {
    return $.ajax({
        headers: {
            "accept": "application/json",
            "content-type": "application/json"
        },
        type: "GET",
        url: "http://localhost:8080/api/employees/show_list"
    })
        .done((data) => {
            console.log(data)
            if (data.length === 0) {
                let str=`<option value="0">Chọn nhân viên</option>`;
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





