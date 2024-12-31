/*
wichtig zum lernen-> 

// Wählen das erste Element mit der Klasse 'nav-punkte1'
var navColChange = document.querySelector('#nav1');

// wichtig: querySelector() -> gibt **ein einziges Element** zurück, das dem angegebenen Selektor entspricht (im Falle von '.navColChange' das erste Element mit dieser Klasse).
// getElementsByClassName() -> gibt eine **HTMLCollection** (Sammlung) von Elementen zurück, die mit der angegebenen Klasse übereinstimmen. 
// Diese Sammlung ist **lebendig**, das bedeutet, sie wird aktualisiert, wenn Elemente hinzugefügt oder entfernt werden. 
// Beachte: getElementsByClassName() gibt keine einzelne Referenz zurück, sondern eine Sammlung (auch wenn nur ein Element vorhanden ist).

// Event Listener für das Element hinzufügen (normale Funktion)
navColChange.addEventListener('click', function() {
  // 'this' zeigt auf das geklickte Element
  this.style.color = "aqua"; // hier zeigt this auf das aktuelle objekt wobei in einem arrowFunction, er auf das windows zeigt, was zur falsche ergebnisse fuehren kannn. 
});

*/

// Alle Elemente mit der Klasse 'nav-punkte' auswählen
const navItems = document.querySelectorAll('.nav-punkte');

// Für jedes Element einen Event Listener hinzufügen
navItems.forEach((item) => {
  item.addEventListener('click', function () {
    // Entfernt vorherige aktive Farben (optional, wenn nur ein Element hervorgehoben sein soll)
    navItems.forEach((nav) => nav.style.color = '');

    // Farbe für das angeklickte Element setzen
    this.style.color = 'aqua';
  });
});

// Füge sanftes Scrollen für den Shops-Link hinzu
let shopLink = document.querySelector('a[href="#shops"]');

shopLink.addEventListener('click', (event) => {
    event.preventDefault(); // Verhindert das Standardverhalten des Links
    
    document.querySelector('#shops').scrollIntoView({
        behavior: 'smooth', // Sanftes Scrollen
        block: 'start' // Scrollt bis zum Anfang des Abschnitts
    });
});
/* jetzt das gleiche fuer blogs machen  */

let blogs = document.querySelector('a[href="#blogs"]'); // wenn oben nav auf den links mit id=blogs geklickt wird der von 'a[href=id,class...] kommt
blogs.addEventListener('click', ()=>{
  event.preventDefault(); // verhindere das Standaradverhalten des Links 
  document.querySelector('#blogs').scrollIntoView({
    behavior: 'smooth', 
    block: 'start'
  });
});

/* jetzt, das gleiche auch für button machen  */


/*wenn das button in der shopliste(add to cart) geklickt wird, 
dass es dann zum cart hinzugefuegt werden soll .  */


// 🛒 Array zur Speicherung der hinzugefügten Produkte
let cartItems = []; 

// 🔍 Selektiere notwendige Elemente
const addToCartButtons = document.querySelectorAll('.add');
const cartIcon = document.querySelector('#cart');
const cartOverlay = document.querySelector('#cart-overlay');
const cartItemsContainer = document.querySelector('#cart-items');
const closeCartButton = document.querySelector('#close-cart');

//  Event-Listener für "Add To Cart"-Buttons
addToCartButtons.forEach((button) => {
    button.addEventListener('click', (event) => {
        const card = event.target.closest('.card');
        const title = card.querySelector('.card-Beschreibung').innerText; 
        const image = card.querySelector('.card-image img').src; 

        const product = { title, image };
        cartItems.push(product);

        updateCartIcon();
        renderCartItems();
    });
});

// 🔄 Aktualisiere das Warenkorb-Icon
function updateCartIcon() {
    const cartCount = cartItems.length;
    cartIcon.innerHTML = `<i class="fa-solid fa-cart-shopping"></i> (${cartCount})`;
}

// 🛒 Zeige Produkte im Warenkorb an
function renderCartItems() {
    // 🧹 Lösche vorherige Inhalte
    cartItemsContainer.innerHTML = '';

    // 🖌️ Erstelle Karten für jedes Produkt im Warenkorb
    cartItems.forEach((item, index) => {
        const cartItem = document.createElement('div');
        cartItem.classList.add('cart-item');
        cartItem.innerHTML = `
            <img src="${item.image}" alt="${item.title}" style="width: 50px; height: 50px; object-fit: cover;">
            <p>${item.title}</p>
            <button class="remove-item" data-index="${index}">Entfernen</button>
        `;
        cartItemsContainer.appendChild(cartItem);
    });

    // 🗑️ Event-Listener für "Entfernen"-Buttons
    document.querySelectorAll('.remove-item').forEach((button) => {
        button.addEventListener('click', (event) => {
            const index = event.target.dataset.index;
            cartItems.splice(index, 1);
            updateCartIcon();
            renderCartItems();
        });
    });
}

//  Öffne den Warenkorb beim Klicken auf das Warenkorb-Icon
cartIcon.addEventListener('click', () => {
    cartOverlay.style.display = 'block';
    renderCartItems();
});

//  Schließe den Warenkorb
closeCartButton.addEventListener('click', () => {
    cartOverlay.style.display = 'none';
});
