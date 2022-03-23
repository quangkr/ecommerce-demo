document.addEventListener('DOMContentLoaded', () => {
    initializeToasts();

    const addToCartButton = document.querySelector('.add-to-cart-container button');
    addToCartButton.addEventListener('click', handleAddToCart);
});

async function handleAddToCart(e) {
    e.preventDefault();
    const button = e.target;
    if (button.classList.contains('disabled')) {
        return;
    }

    const parent = e.target.parentElement;
    const input = parent.querySelector('input');
    const successToast = bootstrap.Toast.getInstance(document.getElementById('toast-add-success'));
    const failedToast = bootstrap.Toast.getInstance(document.getElementById('toast-add-failed'));

    const productId = parent.getAttribute('data-product-id');
    const quantity = input.value ? input.value : 1;

    button.classList.add('disabled');
    button.setAttribute('aria-disabled', true);
    button.setAttribute('tabindex', -1);

    const res = await fetchHelper(`${APP_CONSTANTS.contextRoot}/cart/`, {
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
        successToast.show();
    } else {
        failedToast.show();
    }
}