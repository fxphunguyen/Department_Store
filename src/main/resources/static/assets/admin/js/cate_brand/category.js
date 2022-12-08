
const  selectBtnCat = document.querySelector('.select-btn-cat');
const  searchCatBtn = document.querySelector('#inputSearchCat')
//nhat-dev class category
class  Category{
    constructor(id,name) {
        this.id = id;
        this.name = name;
    }
}
//nhat-dev obj category
let category = new Category();

//show all categories
let categories;
function showAllCategories(selectedCountry) {
    options.innerHTML = "";
    return $.ajax({
        headers: {
            "accept": "application/json",
            "content-type": "application/json"
        },
        type: "GET",
        url: "http://localhost:8080/api/categories"
    })
        .done((data) => {
            categories = data;
            categories.forEach(item => {
                let isSelected = item === selectedCountry ? "selected" : "";
                let str = `<li data-id="${item.id}" onclick="updateNameCat(this)" class="${isSelected} catItem dropdown-item">${item.name}</li>`;
                // options.insertAdjacentHTML("beforeend", li);
                $(".showAllCategory").append(str);

            });

        })
        .fail((jqXHR) => {

        })
}

//update name cat
function updateNameCat(selectedLiCat) {
    searchCatBtn.value = "";
    showAllCategories(selectedLiCat.innerText);
    wrapper.classList.remove("active");
    selectBtnCat.firstElementChild.innerText= selectedLiCat.innerText;
    console.log(selectedLiCat)
}
//search cat
const  searchCat = () => {
    $('#inputSearchCat').on("input", function () {
        let searchWord = $('#inputSearchCat').val();
        console.log(searchWord)
        let arr = [];
        categories.forEach(item => {
            if ((item.name).toLowerCase().includes(searchWord.toLowerCase())){
                arr.push(item)
            }
        })
        console.log(arr)
        // r
        $.each(arr, (i, item) => {
            console.log(item)
            let isSelected = item === selectBtnCat.firstElementChild.innerText ? "selected" : "";
            let result =  `<li data-id="${item.id}" onclick="updateNameCat(this)" class="${isSelected} catItem dropdown-item">${item.name}</li>`;
            $(".showAllCategory").append(result);
        })
    })
}
//Nhat-dev show create category modal
$('#btnCreateCat').on('click', () => {
    $('#modalAddCategory').modal('show');
})

//Nhat-dev OnClick button to create Category
$('#btnAddCategory').on('click', () => {
    category.id = 0;
    category.name = $('#inputCategory').val();
    console.log(category)
    $.ajax({
        "headers": {
            "accept": "application/json",
            "content-type": "application/json"
        },
        "type": "POST",
        "url": "http://localhost:8080/api/categories/create",
        "data": JSON.stringify(category)
    })
        .done((data) => {
            console.log(": Tạo sản phẩm thành công")
            showAllCategory();
            $('#modalAddCategory').modal('hide');
            $('#frmCreateCat')[0].reset();

        })
        .fail((jqXHR) => {
            console.log("Loi nha may ba")
        })
})

//called function
showAllCategories();
searchCat();