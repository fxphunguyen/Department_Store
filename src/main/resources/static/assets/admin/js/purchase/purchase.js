let supplier = new Supplier();
let locationRegionCreate = new LocationRegionCreate();

function showListSupplier() {
    $.ajax({
        type: "GET", contentType: 'application/json', url: `${location.origin}/api/admin/suppliers`
    })
        .done((data) => {
            console.log(data)
            $(".searchSupplier").removeClass('d-none');
            $(".contentSupplier div").remove();
            $.each(data, (i, supplier) => {
                let result = `
                     <div class="collection-select clearfix single-suggest-select " id="item-suggest-suppliers-182236815">
                        <a class="pull-left">
                           <img style="width:30px;float:left;padding-top:3px"
                               src="https://4ae.mysapogo.com/v2/images/customper-noavatar.png" >
                                 <div style="width:calc(100% - 30px);float:left;padding-left:10px">
                                      <p>${supplier.name}</p>
                                      <p>${supplier.phone}</p>
                                 </div>
                        </a>
                     </div>
                `;
                $(".contentSupplier").append(result)
            })

            handleCloseListSupplier();
        })
        .fail((jqXHR) => {
            console.log(jqXHR);
        })
}

function handleCloseListSupplier() {
    $(document).on("click", () => {
        // $(".contentCustomer div").empty();
        $(".searchSupplier").addClass('d-none');
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
