(() => {
    return $.ajax({
        "headers": {
            "accept": "application/json",
            "content-type": "application/json"
        },

        "type": "get",
        "url": "http://localhost:8080/api/admin/purchases"
    })
    .done((data) => {
        console.log(data);
            $.each(data, (i, item) => {
                $("tbody").append(`
                <tr class="tr tr-18191424 odd" role="row">
                                            <td class="select td select--drill-down" nametd="drill_down"
                                                style="width: 26px;">
                                                <div style="width: 14px;">
                                                    <a href="javascript:void(0)" class="btn-quick-view"
                                                       id="btn-quick-view-18191424"><i
                                                            class="fa fa-angle-double-right fa-lg drill-down-icon"></i></a>
                                                </div>
                                            </td>
                                            <td class="select td bulk-action" nametd="bulk_action">
                                                <div class="next-input-wrapper">
                                                    <input type="checkbox" value="18191424">
                                                    <span class="next-checkbox--styled"><svg
                                                            class="next-icon next-icon--size-10 checkmark">
                                                                        <use xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                             xlink:href="#next-checkmark-thick"></use>
                                                                    </svg></span>
                                                </div>
                                            </td>
                                            
                                            
                                            <td nametd="supplier_name" class="cursor-pointer name td">
                                            <span>${item.purchaseOrderCode}</span>
                                            </td>
                                            
                                            <td class="cursor-pointer name td hidden">
                                            <span>${item.supplierId}</span>
                                            </td>
                                            
                                            <td nametd="location_name" class="cursor-pointer name td">
                                            <span>Chi nhánh mặc định</span>
                                            </td>
                                            
                                            <td nametd="status_translated" class="cursor-pointer name td">
                                            <span class="text--limeade">${item.status}</span>
                                            </td>
                                            
                                            <td nametd="payment_status_translated"
                                                class="cursor-pointer name td">
                                            <span class="text--limeade">${item.pays}</span>
                                            </td>
                                            
                                            <td nametd="receive_status_translated"
                                                class="cursor-pointer name td">
                                            <span class="text--limeade">Đã nhập hàng</span>
                                            </td>
                                            
                                            <td nametd="total_amount"
                                                class="cursor-pointer name td align-right">
                                            <span>${item.grandTotal}</span>
                                            </td>
                                            
                                            <td nametd="actived_account_id"
                                                class="cursor-pointer name td hidden">
                                            <span>${item.employeeId}</span>
                                            </td>
                `);
            });
    })
        .fail((jqXHR) => {
            console.log("An error occurred: " + jqXHR);
        });
})();