- ~~TaskManager~~
- Config
- Persistence
- Formatting Utils
- Adventure I18n
- Sharding

```kotlin
    @EventHandler
    fun join(event: PlayerJoinEvent) {
        val request = ResourcePackRequest.resourcePackRequest()
            .packs(
                ResourcePackInfo.resourcePackInfo(
                    UUID.randomUUID(),
                    URI.create("https://www.curseforge.com/api/v1/mods/353554/files/6534716/download"),
                    "Stay True Resource Pack"
                ),
                ResourcePackInfo.resourcePackInfo(
                    UUID.randomUUID(),
                    URI.create("https://cdn.modrinth.com/data/RvfAlf4Z/versions/XauQUBeR/Redstone%20Tweaks%202.5.3.zip"),
                    "Redstone Tweaks Resource Pack"
                )
            )
            .replace(true)
            .required(true)
            .prompt(Component.text("This server requires a resource pack to play. Do you want to download it?"))
            .build()

        event.player.sendResourcePacks(request)
    }
```