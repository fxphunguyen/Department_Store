function showListCustomer() {
    $(".searchCustomer").removeClass('d-none');
    $.ajax({
        type: "GET", contentType: 'application/json', url: `${location.origin}/api/customers/list_customer`,
    })
        .done((data) => {
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
        })
        .fail((jqXHR) => {
            fail(jqXHR);
        })
}

function showCustomerInfo(idCustomer) {
    alert(idCustomer)
}


function handleCloseListCustomers() {
    $(document).on("click", () => {
        $(".contentCustomer").empty();
    })
}

handleCloseListCustomers();