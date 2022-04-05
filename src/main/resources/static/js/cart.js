import { CONTEXT_ROOT } from './modules/constants.js';
import { fetchHelper, isNum } from './modules/utils.js';
import { loadingModal, hasShown } from './modules/loadingModal.js';

async function handleRemove(e) {
    e.preventDefault();
    const productId = e.currentTarget.getAttribute('data-product-id');

    const res = await fetchHelper(`${CONTEXT_ROOT}/cart/`, {
        method: 'DELETE',
        body: JSON.stringify([productId]),
    });

    window.location.reload();
}

async function handleChange(e) {
    e.preventDefault();
    const productId = e.target.getAttribute('data-product-id');
    const parent = e.target.parentElement;
    const oldQuantity = e.target.getAttribute('data-quantity');
    const quantity = e.target.value;

    loadingModal.show();
    const shown = hasShown();

    if (isNum(quantity) && quantity > 0) {
        var res = await fetchHelper(`${CONTEXT_ROOT}/cart/`, {
            method: 'PUT',
            body: JSON.stringify({
                productId,
                quantity,
            }),
        });
    }

    if (!res || !res.ok) {
        e.target.value = oldQuantity;
    } else {
        const json = await res.json();
        const quantityBadge = document.getElementById('navbar-cart-quantity');
        const grandTotalElement = document.getElementById('cart-grand-total');

        quantityBadge.textContent = json.totalQuantity;
        grandTotalElement.textContent = `${json.grandTotal.toLocaleString()} đ`;
        e.target.setAttribute('data-quantity', quantity);
    }

    loadingModal.hide();
    shown.then(() => {
        loadingModal.hide();
    });
}

function handleIncrease(e) {
    const parent = e.target.parentElement;
    const input = parent.querySelector('input');

    input.value++;
    input.dispatchEvent(new Event('change'));
}

function handleDecrease(e) {
    const parent = e.target.parentElement;
    const input = parent.querySelector('input');
    if (input.value <= 1) {
        return;
    }

    input.value--;
    input.dispatchEvent(new Event('change'));
}

document.addEventListener('DOMContentLoaded', () => {
    const inputGroups = document.querySelectorAll('.cart-item');
    Array.prototype.forEach.call(inputGroups, function (group) {
        group.querySelector('.input-quantity').addEventListener('change', handleChange);
        group.querySelector('.btn-decrease').addEventListener('click', handleDecrease);
        group.querySelector('.btn-increase').addEventListener('click', handleIncrease);
        group.querySelector('.btn-remove').addEventListener('click', handleRemove);
    });
});
