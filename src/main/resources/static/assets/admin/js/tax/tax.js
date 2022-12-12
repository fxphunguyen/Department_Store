
const  selectBtnTax = document.querySelector('.select-btn-tax');
let taxes;
function showAllTaxes(selectedTax) {
    return $.ajax({
        headers: {
            "accept": "application/json",
            "content-type": "application/json"
        },
        type: "GET",
        url: "http://localhost:8080/api/taxes"
    })
        .done((data) => {
            taxes = data;
            taxes.forEach(item => {
                //nhat-dev select item and get it value
                let isSelected = item === selectedTax ? "selected" : "";
                let str = `<li id="${item.id}" data-id="${item.id}" onclick="updateNameTax(${item.id})" class="${isSelected} catItem dropdown-item">${item.title}</li>`;
                // options.insertAdjacentHTML("beforeend", li);
                $(".showAllTax").append(str);

            });

        })
        .fail((jqXHR) => {

        })
}
//nhat-dev update name cat after selected
function updateNameTax(id ) {
    const  arrayTax = taxes.filter(item => item.id === id)
    const val = arrayTax[0].title;

    console.log("is", id , val)

    selectBtnTax.firstElementChild.innerText= val;

    //add data-id on element span tag name
    $("#taxProType").data("id", id);

    // $("#getIdValueCat").data("id", id);


    let idValue = $("#taxProType").data("id");
    console.log(idValue);
    // $('#getIdValueCat').val(idValue);
    // console.log($('#getIdValueCat').val(idValue))


    // console.log($("#getIdValueCat").prop('data-id', id))

}
//Nhat-dev show create category modal
$('#btnCreateCat').on('click', () => {
    $('#modalAddCategory').modal('show');
})



