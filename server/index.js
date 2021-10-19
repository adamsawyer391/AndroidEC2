var http = require('http')
//var datafile = require('./datafile');

var server = http.createServer(function(req, res){
    if(req.url == '/'){
        res.setHeader("Content-type", "application/json");
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.writeHead(200);
        let dataObject = { id: 100, name: 'Walter White', email: 'chickenbrothers@fring.com' };
        let data = JSON.stringify(dataObject);
        res.end(data);
    }
    else if(req.url == '/star-trek'){
        res.setHeader("Content-type", "application/json");
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.writeHead(200);
        let dataObject = [
            {
                id: 1,
                name: "Harold Cricke",
                phone: '978-555-0001',
                url: 'https://thatmomentin.com/wp-content/uploads/2016/08/Screen-Shot-2016-08-21-at-6.54.17-AM-650x380.png'
            },
            {
                id: 2,
                name: "Jean-Luc Picard",
                phone: '978-555-0002',
                url: 'https://www.indiewire.com/wp-content/uploads/2018/08/shutterstock_2115457cs.jpg'
            },
            {
                id: 3,
                name: "Katherine Janeway",
                phone: '978-555-0003',
                url: 'https://exclaim.ca/images/kate_mulgrew_janeway.jpg'
            },
            {
                id: 4,
                name: "Benjamin Sisko",
                phone: '978-555-0004',
                url: 'https://i0.wp.com/thenerdsofcolor.org/wp-content/uploads/2013/09/benjamin_sisko_captain.jpg'
            },
            {
                id: 5,
                name: "Jonathan Archer",
                phone: '978-555-0005',
                url: 'https://am24.mediaite.com/tms/cnt/uploads/2020/03/captain-archer-scott-bakula-star-trek-enterprise.jpg'
            },
            {
                id: 6,
                name: "Chakotay",
                phone: '978-555-0006',
                url: 'https://pbs.twimg.com/media/DRVLrDfW4AAf_IF.jpg'
            },
            {
                id: 7,
                name: "Kes",
                phone: '978-555-0007',
                url: 'http://images2.fanpop.com/image/photos/9900000/Kes-star-trek-women-9919601-350-402.jpg'
            },
            {
                id: 8,
                name: "The Doctor",
                phone: '978-555-0008',
                url: 'https://www.giantfreakinrobot.com/wp-content/uploads/2020/10/doctorvoyager34.jpg'
            },
            {
                id: 9,
                name: "Data",
                phone: '978-555-0009',
                url: 'https://i.pinimg.com/originals/12/d1/f8/12d1f8b73796e5042f38cfe4c16558b1.jpg'
            },
            {
                id: 10,
                name: "Belanna Torres",
                phone: '978-555-00010',
                url: 'https://i.pinimg.com/originals/65/5e/07/655e0709ac9bffbbcc0948d0b33ba0c8.jpg'
            },
        ]
        let data = JSON.stringify(dataObject);
        res.end(data);
    }
    else {
        res.end('Invalid url')
    }
});

server.listen(5000, function() {
    console.log('Server running on port 5000');
})