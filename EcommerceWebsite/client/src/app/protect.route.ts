import { CanActivateFn } from "@angular/router";

export const protectRoute: CanActivateFn = (route, state) => {
    const token = localStorage.getItem('token');
    return !!token;
}