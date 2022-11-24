(() => {
    return $.ajax({
        "headers": {
            "accept": "application/json",
            "content-type": "application/json"
        },
        "type": "get",
        "url": "http://localhost:8080/api/admin/suppliers"
    })
    .done((data) => {
        $.each(data, (i, item) => {
            $("tbody").append(`
                <tr>
                    <td class="select bulk-action">
                        <div class="next-input-wrapper">
                            <input type="checkbox" class="bulk-action-item next-checkbox" value="${item.id}"/>
                            <span class="next-checkbox--styled">
                                <svg class="next-icon next-icon--size-10 checkmark">
                                    <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#next-checkmark-thick"></use>
                                </svg>
                            </span>
                        </div>
                    </td>
                    <td>
                        <a style="text-decoration: underline;" href="/admin/suppliers/${item.id}/histories" title="${item.supplierCode}">${item.supplierCode}</a>
                    </td>
                    <td>
                        <span title="${item.name}">${item.name}</span>
                    </td>
                    <td>
                        <span title="${item.email}">${item.email}</span>
                    </td>
                    <td>
                        <span title="${item.phone}">${item.phone}</span>
                    </td>
                    <td>
                        <span class="${item.supplierStatus === 'Đang giao dịch' ? 'text-success' : 'text-danger'}" title="${item.supplierStatus}">${item.supplierStatus}</span>
                    </td>
                    <td>
                        <span title="${item.employeeResult.name}">${item.employeeResult.name}</span>
                    </td>
                    <td>
                        <span title="${item.createAt}">${item.createAt}</span>
                    </td>
                    <td>
                        <span title="${item.updateAt}">${item.updateAt}</span>
                    </td>
                </tr>
            `);
        });
    })
    .fail((jqXHR) => {
        console.log("An error occurred: " + jqXHR);
    });
})();