[![](http://cf.way2muchnoise.eu/full_557549_downloads.svg)](https://www.curseforge.com/minecraft/mc-mods/had-enough-items) [![Discord](https://img.shields.io/discord/926486493562814515.svg?colorB=7289DA&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHYAAABWAgMAAABnZYq0AAAACVBMVEUAAB38%2FPz%2F%2F%2F%2Bm8P%2F9AAAAAXRSTlMAQObYZgAAAAFiS0dEAIgFHUgAAAAJcEhZcwAACxMAAAsTAQCanBgAAAAHdElNRQfhBxwQJhxy2iqrAAABoElEQVRIx7WWzdGEIAyGgcMeKMESrMJ6rILZCiiBg4eYKr%2Fd1ZAfgXFm98sJfAyGNwno3G9sLucgYGpQ4OGVRxQTREMDZjF7ILSWjoiHo1n%2BE03Aw8p7CNY5IhkYd%2F%2F6MtO3f8BNhR1QWnarCH4tr6myl0cWgUVNcfMcXACP1hKrGMt8wcAyxide7Ymcgqale7hN6846uJCkQxw6GG7h2MH4Czz3cLqD1zHu0VOXMfZjHLoYvsdd0Q7ZvsOkafJ1P4QXxrWFd14wMc60h8JKCbyQvImzlFjyGoZTKzohwWR2UzSONHhYXBQOaKKsySsahwGGDnb%2FiYPJw22sCqzirSULYy1qtHhXGbtgrM0oagBV4XiTJok3GoLoDNH8ooTmBm7ZMsbpFzi2bgPGoXWXME6XT%2BRJ4GLddxJ4PpQy7tmfoU2HPN6cKg%2BledKHBKlF8oNSt5w5g5o8eXhu1IOlpl5kGerDxIVT%2BztzKepulD8utXqpChamkzzuo7xYGk%2FkpSYuviLXun5bzdRf0Krejzqyz7Z3p0I1v2d6HmA07dofmS48njAiuMgAAAAASUVORK5CYII%3D)](https://discord.gg/f2K4aSpG4F)

# HadEnoughItems (HEI)
[HadEnoughItems](https://discord.gg/f2K4aSpG4F) is an Item and Recipe viewing mod for Minecraft with a focus on stability, performance, and ease of use.

This means (same as JEI of course):
 * Just items and recipes
 * Clean API for developers
 * Not a coremod – no dependencies other than Forge.
 
 New features in HEI:
 * Memory optimizations
 * Load time optimizations
 * Render optimizations
 * Able to change default fluid containers for when you pick up fluids from the ingredient menu
 * Able to fill fluid containers by clicking on fluids in the ingredient menu
 * Able to order bookmarks differently
 * Consider diacritics when searching
 * Removable "Recipe By" tooltip in recipe menu
 * More information available in recipe tabs
 * Better ordering of recipes in certain contexts

### For Devs:
Add CleanroomMC's repository and depend on HEI's maven entry:
```groovy
repositories {
    maven {
        url 'https://maven.cleanroommc.com'
    }
}

dependencies {
    implementation 'mezz:jei:4.27.2'
}
