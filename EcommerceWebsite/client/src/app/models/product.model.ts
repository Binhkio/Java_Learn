import { Catergory } from "./category.model";

export interface Product {
    readonly id: number;
    name: string;
    brand: string;
    madein: string;
    price: number;
    category: Catergory;
}