import { Product } from "./product.model";

export interface Item {
    readonly id: number;
    product: Product;
    quantity: number;
}