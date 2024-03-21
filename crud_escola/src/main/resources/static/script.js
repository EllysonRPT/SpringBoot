const carousel = document.querySelector('.carousel');
const images = document.querySelectorAll('.carousel img');
const prevBtn = document.querySelector('.prev-btn');
const nextBtn = document.querySelector('.next-btn');
const totalImages = images.length;
let currentIndex = 0;

function showImage(index) {
  images.forEach((img, i) => {
    img.style.transform = `translateX(-${index * 100}%)`;
  });
}

function nextImage() {
  currentIndex = (currentIndex + 1) % totalImages;
  showImage(currentIndex);
}

function prevImage() {
  currentIndex = (currentIndex - 1 + totalImages) % totalImages;
  showImage(currentIndex);
}

nextBtn.addEventListener('click', nextImage);
prevBtn.addEventListener('click', prevImage);

// Autoplay
let autoplayInterval = setInterval(nextImage, 3000); // Altere o intervalo conforme necessário

carousel.addEventListener('mouseenter', () => {
  clearInterval(autoplayInterval);
});

carousel.addEventListener('mouseleave', () => {
  autoplayInterval = setInterval(nextImage, 3000);
});
