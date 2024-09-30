import { Item } from "./item.model";

export interface Cart {
    readonly id: number;
    items: Item[];
}