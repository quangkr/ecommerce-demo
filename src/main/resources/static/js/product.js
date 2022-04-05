import { CONTEXT_ROOT } from './modules/constants.js';
import { fetchHelper, isNum } from './modules/utils.js';
import { showToast } from './modules/toasts.js';
import { loadingModal, hasShown } from './modules/loadingModal.js';

const successMessage = 'Product successfully added!';
const failedMessage = 'There was some error adding product!';

async function handleAddToCart(e) {
    e.preventDefault();
    const button = e.target;
    if (button.classList.contains('disabled')) {
        return;
    }

    const input = e.target.parentElement.parentElement.querySelector('input');
    const productId = button.getAttribute('data-product-id');
    const quantity = input.value;

    button.classList.add('disabled');
    button.setAttribute('aria-disabled', true);
    button.setAttribute('tabindex', -1);
    loadingModal.show();
    const shown = hasShown();

    const res = await fetchHelper(`${CONTEXT_ROOT}/cart/`, {
        method: 'POST',
        body: JSON.stringify({
            productId,
            quantity,
        }),
    });

    button.classList.remove('disabled');
    button.removeAttribute('aria-disabled');
    button.removeAttribute('tabindex');

    loadingModal.hide();
    shown.then(() => {
        loadingModal.hide();
    });

    if (!res || !res.ok) {
        showToast(failedMessage, 'danger');
    } else if (res.redirected) {
        window.location.replace(res.url);
    } else {
        const json = await res.json();
        const quantityBadge = document.getElementById('navbar-cart-quantity');
        quantityBadge.textContent = json.totalQuantity;
        showToast(successMessage, 'success');
    }
}

function handleIncrease(e) {
    const input = e.target.parentElement.querySelector('input');
    input.value++;
    input.dispatchEvent(new Event('change'));
}

function handleDecrease(e) {
    const input = e.target.parentElement.querySelector('input');
    input.value--;
    input.dispatchEvent(new Event('change'));
}

function handleChange(e) {
    if (isNum(e.target.value) && e.target.value > 0) {
        e.target.setAttribute('data-quantity', e.target.value);
    } else {
        e.target.value = e.target.getAttribute('data-quantity');
    }
}

document.addEventListener('DOMContentLoaded', () => {
    document.querySelector('.add-to-cart-container .btn-decrease').addEventListener('click', handleDecrease);
    document.querySelector('.add-to-cart-container .btn-increase').addEventListener('click', handleIncrease);
    document.querySelector('.add-to-cart-container .input-quantity').addEventListener('change', handleChange);
    document.querySelector('.add-to-cart-container .btn-add-to-cart').addEventListener('click', handleAddToCart);
});
