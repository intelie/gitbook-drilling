# Standard Identifiers

To support some out-of-the-box analyses provided by Intelie, a set of common identifiers must be configured.

When those fields are configured, some macros are enabled to support the access to that specific mnemonics. For example, when configured, `@@channels.bit_depth` will refer to the bit depth mnemonic, whatever it is, in any environment.

![Example of identified channels](<../.gitbook/assets/image (458).png>)

| **Channel**                | **Pipes macro**                         |
| -------------------------- | --------------------------------------- |
| Bit Depth                  | `@@channels.bit_depth`                  |
| Rotary Speed               | `@@channels.rotary_speed`               |
| Rate of Penetration        | `@@channels.rate_of_penetration`        |
| Hole Depth                 | `@@channels.hole_depth`                 |
| Weight on Bit              | `@@channels.weight_on_bit`              |
| Weight on Hook             | `@@channels.weight_on_hook`             |
| Fluid Flow                 | `@@channels.fluid_flow`                 |
| Block Position             | `@@channels.block_position`             |
| Block Position with Period | `@@channels.block_position_with_period` |
| Magnetic Toolface          | `@@channels.magnetic_tool_face`         |
| Gravitational Toolface     | `@@channels.gravitational_tool_face`    |
| Torque                     | `@@channels.torque`                     |
| Standpipe                  | `@@channels.standpipe`                  |
