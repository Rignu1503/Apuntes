
<template>

  <div class="container-image-profile">
    <div class="background-image-profile">
        <img :src="backgroundImageProfile" alt="">
    </div>

    <div class="info-profile">
        <div class="profile-picture">
            <img :src="imagePerfilProfile" alt="">
        </div>
        
        <div class="datail-profile">
            <div class="name">
                <p>John Doe</p>
            </div>
            <div class="container-detail">
                <div class="datail">
                    <ion-icon name="color-palette-outline"></ion-icon>
                    <p>coder</p>
                </div>
                <div class="datail">
                    <ion-icon name="location-outline"></ion-icon>
                    <p>Medellin</p>
                </div>
                <div class="datail">
                    <ion-icon name="calendar-outline"></ion-icon>
                    <p>Joined April 2021</p>
                </div>
                <div class="datail">
                 
                    <button>connect</button>
                    
                 
                </div>

                


            </div>


        </div>

    </div>
  </div>

</template>

<script setup lang="ts">

//import img
import background from '@/assets/images/background-profile.webp';
import imagePerfil from '@/assets/images/image-perfil.webp';

const backgroundImageProfile = background;
const imagePerfilProfile = imagePerfil;

</script>

<style lang="scss">

.container-image-profile {
    display: flex;
    flex-direction: column;
    height: 300px;


    .background-image-profile{
        height: 70%;
        
        img{
            width: 100%;
            height: 100%;
            object-fit: cover;

        }
    }

    .info-profile{
        display: flex;
        height: 30%;
        background-color: red;
        

        .profile-picture{
            
            img{
                margin-top: -20px;
                border: 5px solid white;
            }
        }

        .datail-profile{
            display: flex;
            flex-direction: column;
            border: 1px solid red;


            .container-detail{
                display: flex;
                flex-direction: row;
                border: 1px solid blue;

                .datail{
                    display: flex;
                    padding: 10px;

                    ion-icon{
                        padding-right: 3px;
                    }
                    
                    button{
                        padding: 10px;
                        background: #7367ef;
                        color: white;
                        padding: 10px 30px;
                        
                    }
                    
                }
            }
        }
    }


}

</style>