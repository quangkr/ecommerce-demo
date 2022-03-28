import { CONTEXT_ROOT } from './modules/constants.js';
import { fetchHelper, isNum } from './modules/utils.js';

document.addEventListener('DOMContentLoaded', () => {
    const inputGroups = document.querySelectorAll('.cart-item');
    Array.prototype.forEach.call(inputGroups, function (group) {
        group.querySelector('.input-quantity').addEventListener('change', handleChange);
        group.querySelector('.btn-decrease').addEventListener('click', handleDecrease);
        group.querySelector('.btn-increase').addEventListener('click', handleIncrease);
        group.querySelector('.btn-remove').addEventListener('click', handleRemove);
    });
});

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

    disableControls(parent);

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
        e.target.setAttribute('data-quantity', quantity);
    }

    enableControls(parent);
}

async function handleIncrease(e) {
    const parent = e.target.parentElement;
    const input = parent.querySelector('input');

    input.value++;
    input.dispatchEvent(new Event('change'));
}

async function handleDecrease(e) {
    const parent = e.target.parentElement;
    const input = parent.querySelector('input');
    if (input.value <= 1) {
        return;
    }

    input.value--;
    input.dispatchEvent(new Event('change'));
}

function disableControls(parent) {
    parent.querySelectorAll('input,button').forEach((c) => {
        c.toggleAttribute('disabled', true);
    });
}

function enableControls(parent) {
    parent.querySelectorAll('input,button').forEach((c) => {
        c.toggleAttribute('disabled', false);
    });
}
