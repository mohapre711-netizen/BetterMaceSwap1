# BetterMaceSwap
A client-side Fabric mod for Minecraft 26.1 that automates mace combat sequences for PvP — no manual hotkey juggling required.

## Features
- Automatically swaps to Mace after hitting with a Sword, then swaps back after a configurable delay
- Supports Density and Breach enchantment modes
- Detects enemy shield blocks and axe-stuns automatically, then follows up with a mace slam
- Automatically fires a Wind Charge after throwing an Ender Pearl (Pearl Catch)
- Camera locks straight up when pearl is thrown at 60° or higher
- Wind charge fires from offhand if available, falls back to hotbar
- Automatically switches to sword after Wind Charge fires
- All features toggleable via keybinds or Mod Menu config screen
- Target filters: Players, Mobs, Animals

## Requirements
- Fabric Loader 0.18.4+
- Fabric API
- Cloth Config
- Mod Menu
- Java 21
- Minecraft 26.1

## Building
```
gradlew build
```

## Keybinds
Find these in Minecraft Controls under **BetterMaceSwap**:
- **Toggle Auto Attribute Swap** — default: B
- **Toggle Stun Slam** — default: V
- **Cycle Mace Mode (Density / Breach)** — default: N
- **Toggle Pearl Catch** — default: M

## License
MIT
