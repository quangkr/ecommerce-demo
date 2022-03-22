document.addEventListener('DOMContentLoaded', () => {
    initializeToasts();

    const inputGroups = document.querySelectorAll('.cart-row');
    Array.prototype.forEach.call(inputGroups, function (group) {
        group.querySelector('input').addEventListener('change', handleChange);
        group.querySelector('.btn-substract').addEventListener('click', handleSubstract);
        group.querySelector('.btn-add').addEventListener('click', handleAdd);
        group.querySelector('.btn-remove').addEventListener('click', handleRemove);
    });
});

async function handleRemove(e) {
    e.preventDefault();
    const productId = getProductId(e.target);

    const res = await fetchHelper(`${APP_CONSTANTS.contextRoot}/cart/`, {
        method: 'DELETE',
        body: JSON.stringify([productId]),
    });

    window.location.reload();
}

async function handleChange(e) {
    e.preventDefault();
    const input = e.target;
    const substractBtn = e.target.parentElement.querySelector('.btn-substract');
    const addBtn = e.target.parentElement.querySelector('.btn-add');

    disableControls([substractBtn, addBtn, input]);
    const res = await updateCart(input);
    enableControls([substractBtn, addBtn, input]);
}

async function handleAdd(e) {
    e.preventDefault();
    const input = e.target.parentElement.querySelector('input');
    const substractBtn = e.target.parentElement.querySelector('.btn-substract');
    const addBtn = e.target;
    input.value++;

    disableControls([substractBtn, addBtn, input]);
    const res = await updateCart(input);
    enableControls([substractBtn, addBtn, input]);
}

async function handleSubstract(e) {
    e.preventDefault();
    const input = e.target.parentElement.querySelector('input');
    if (input.value <= 1) {
        return;
    }

    const substractBtn = e.target;
    const addBtn = e.target.parentElement.querySelector('.btn-add');
    input.value--;

    disableControls([substractBtn, addBtn, input]);
    const res = await updateCart(input);
    enableControls([substractBtn, addBtn, input]);
}

function disableControls(controls) {
    controls.forEach((c) => {
        c.toggleAttribute('disabled', true);
    });
}

function enableControls(controls) {
    controls.forEach((c) => {
        c.toggleAttribute('disabled', false);
    });
}

function getProductId(e) {
    const attrName = 'data-product-id';
    let result = e;
    while (!result.hasAttribute(attrName)) {
        result = result.parentNode;
    }

    return result.getAttribute(attrName);
}

async function updateCart(input) {
    const productId = getProductId(input);
    const quantity = input.value;

    const res = await fetchHelper(`${APP_CONSTANTS.contextRoot}/cart/`, {
        method: 'PUT',
        body: JSON.stringify({
            productId,
            quantity,
        }),
    });

    return res;
}
