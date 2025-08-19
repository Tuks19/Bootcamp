/*1-Top clientes con más facturas*/
select 
	cl.nro_cedula as cliente,
	count(*) as CantFacturas
from cliente cl
	join factura f on cl.id = f.cliente_id
group by cliente 
order by cantfacturas desc

/*2- Top clientes que más gastaron*/
select 
	cl.nro_cedula as cliente, 
	round(coalesce(sum(fd.cantidad * p.costo ), 0)) as totalGastado
from cliente cl
	join factura f on cl.id = f.cliente_id
	join factura_detalle fd on f.id = fd.factura_id
	join producto p on fd.producto_id = p.id
group by cliente 
order by totalgastado desc

/*3-Top monedas más utilizadas*/
select 
	m.nombre,
	coalesce(count(*),0) as veces_usada
from moneda m 
	join factura f on m.id = f.moneda_id
group by m.nombre 
order by veces_usada desc

/*4-Top proveedor de Productos*/
select 
	p.nombre as Proveedor,
	coalesce(count(pr.proveedor_id  ),0) as veces_proveidas
from proveedor p 
	join producto pr on p.id = pr.proveedor_id 
group by proveedor 
order by veces_proveidas desc

/*5-Productos mas vendidos*/
select 
	p.nombre as producto,
	coalesce(count(*),0) as veces_comprado
from producto p 
	join factura_detalle fd on p.id = fd.producto_id
group by producto 
order by veces_comprado desc

/*6-Productos menos vendidos */
select 
	p.nombre as producto,
	coalesce(count(*),0) as veces_comprado
from producto p 
	join factura_detalle fd on p.id = fd.producto_id
group by producto 
order by veces_comprado asc

/*7-Consulta que muestre fecha de emisión de factura, nombre y apellido del cliente, 
 * nombres de productos de esa factura, cantidades compradas, nombre de tipo de factura de una factura específica
 */
select 
fa.fecha_emision,
concat(cl.nombre, ' ' ,cl.apellido ) as cliente,
ft.nombre as tipo_de_factura,
p.nombre as producto, 
round(fd.cantidad ) as cant_comprada
from factura fa
	join cliente cl on fa.cliente_id = cl.id
	join factura_tipo ft on fa.factura_tipo_id = ft.id
	join factura_detalle fd on fa.id = fd.factura_id 
	join producto p on fd.producto_id = p.id

/*8-Montos de facturas ordenadas según totales*/
select 
	f.id,
	round(coalesce(sum(fd.cantidad * p.costo ),0)) as total
from factura f 
	join factura_detalle fd on f.id = fd.factura_id
	join producto p on fd.producto_id = p.id 
group by f.id 
order by total desc

/*9-Mostrar el iva 10% de los montos totales de facturas (suponer que todos los productos tienen IVA 10%)*/
select 
    f.id,
    round(coalesce(sum(fd.cantidad * p.costo), 0)) as subtotal,
    round(coalesce(sum(fd.cantidad * p.costo), 0)) * 0.10 as iva_10,
    round(coalesce(sum(fd.cantidad * p.costo), 0)) * 1.10 as total_con_iva
from factura f 
    join factura_detalle fd on f.id = fd.factura_id
    join producto p on fd.producto_id = p.id 
group by f.id 
order by subtotal desc;