import { CanActivateFn } from "@angular/router";

export const protectRoute: CanActivateFn = (route, state) => {
    const token = sessionStorage.getItem('access_token');
    return !!token;
}