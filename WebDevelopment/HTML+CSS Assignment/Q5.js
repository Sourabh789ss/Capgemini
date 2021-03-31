function changeBy()
{
    const images=[
        'url("Pimg1.jpg")',
        'url("Pimg2.jpg")',
        'url("Pimg3.jpg")',
        'url("Pimg4.jpg")',
        'url("Pimg5.jpg")'
     ]

     const selection=document.querySelector('header')
     const bg=images[Math.floor(Math.random()* images.length)];
     Headers.style.backgroundImage=bg;
}
 setInterval(changeBy,1000)