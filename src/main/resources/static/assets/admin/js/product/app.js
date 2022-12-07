class App {
    static DOMAIN_API = "http://localhost:8080";
    static BASE_URL_Product = this.DOMAIN_API + "/api/products";
    static BASE_URL_Categories = this.DOMAIN_API + "/api/categories";
    static BASE_URL_Brands = this.DOMAIN_API + "/api/brands";


}
class Img {
    constructor(name, url) {
        this.name = name;
        this.url = url;
    }
}

class Product {
    constructor(id, title, image, status, description, unit, sku, barCode, quantity, retailPrice, importPrice, wholesalePrice, categoryId, brandId, deleted) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.status = status;
        this.description = description;
        this.unit = unit;
        this.sku = sku;
        this.barCode = barCode;
        this.quantity = quantity;
        this.retailPrice = retailPrice;
        this.importPrice = importPrice;
        this.wholesalePrice = wholesalePrice;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.deleted = deleted;
    }
}