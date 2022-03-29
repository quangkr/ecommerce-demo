import { CONTEXT_ROOT } from './modules/constants.js';
import { fetchHelper } from './modules/utils.js';
import { showToast } from './modules/toasts.js';

const successMessage = 'Product successfully added!';
const failedMessage = 'There was some error adding product!';

async function handleAddToCart(e) {
    e.preventDefault();
    const button = e.target;
    if (button.classList.contains('disabled')) {
        return;
    }

    const parent = e.target.parentElement;
    const input = parent.querySelector('input');

    const productId = parent.getAttribute('data-product-id');
    const quantity = input.value ? input.value : 1;

    button.classList.add('disabled');
    button.setAttribute('aria-disabled', true);
    button.setAttribute('tabindex', -1);

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

    if (res.ok) {
        showToast(successMessage, 'success');
    } else {
        showToast(failedMessage, 'danger');
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const addToCartButton = document.querySelector('.add-to-cart-container button');
    addToCartButton.addEventListener('click', handleAddToCart);
});
